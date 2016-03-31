package ru.niceone.structures

import groovy.json.JsonSlurper

public class MatrixGraph<T> {
    // Матрица смежности
    private List<List<Boolean>> matrix
    // Данные
    private List<T> data
    // Размер графа
    private Integer graphSize
    // Путь, пройденный алгоритм к узлу при выполнении алгоритма
    private ArrayList<Integer> lastPath

    public MatrixGraph() {
        matrix = []
        data = []
    }

    @Deprecated
    public void loadFromFile(File file) {
        int currentLine = 0
        int lastSize = -1

        file.eachLine { line ->
            def sublist = []
            int currentSize = -1

            if (line) {
                ++currentLine

                line = line.tokenize(" ")

                line.each { edge ->
                    sublist << edge.equals("1")
                }

                currentSize = sublist.size()
                if (lastSize == -1 || lastSize == currentSize) {
                    matrix << sublist
                    lastSize = currentSize
                } else {
                    throw new Exception("Row " + currentLine + " doesn't fit to length: got " + currentSize + ", await " + lastSize)
                }
            }

            if (currentSize < currentLine) {
                throw new Exception("Matrix isn't square")
            }

            graphSize = currentSize
        }
    }

    public void loadFromJson(File file) {
        JsonSlurper parser = new JsonSlurper()
        def object = parser.parse(file)

        if (!object) {
            throw new FileNotFoundException("File with data not found")
        }

        if (!object?.values || !(object.values instanceof List)) {
            throw new BadFormatException("'values' field missed or doesn't contains values list")
        }

        if (!object?.matrix || !(object.matrix instanceof List<List>)) {
            throw new BadFormatException("'matrix' field missed or doesn't contains 2d matrix")
        }

        int graphNodesCount = object.values.size()

        if (object.matrix.size() != graphNodesCount) {
            throw new BadFormatException("Cols count in matrix doesn't equal to values count")
        }

        object.matrix.eachWithIndex { val, int i ->
            if (val.size() != graphNodesCount) {
                throw new BadFormatException("Rows count in matrix doesn't equal to values count")
            } else {
                def sublist = []

                object.matrix[i].each { element ->
                    sublist << element.equals(1)
                }

                this.matrix << sublist
            }
        }

        object.values.each { val ->
            this.data << val
        }

        this.graphSize = graphNodesCount
    }

    public SearchResult breadthFirstSearch(T object) {
        ArrayList<Boolean> nodesVisits = []
        ArrayList<Integer> path = []
        Deque<Integer> queue = new ArrayDeque<>()

        // Заполнение признака посещенного узла
        for (def i = 0; i < this.graphSize; i++) {
            nodesVisits << false
        }

        queue << 0
        nodesVisits[0] = true

        while (!queue.isEmpty()) {
            int node = queue.removeFirst()

            path << node

            if (data[node] == object) {
                return new SearchResult(true, path)
            }

            getChildren(node).each { int childNode ->
                if (!nodesVisits[childNode]) {
                    queue.addLast(childNode)
                    nodesVisits[childNode] = true
                }
            }
        }

        return new SearchResult(false, path)
    }

    public List getChildren(int node) {
        def edges = this.matrix[node]
        def nodes = []

        edges.eachWithIndex { edge, i ->
            if (edge)
                nodes << i
        }

        return nodes
    }
}
