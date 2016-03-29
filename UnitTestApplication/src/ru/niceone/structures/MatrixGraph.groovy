package ru.niceone.structures

public class MatrixGraph {
    private List<List<Boolean>> graph
    private Integer graphSize

    public MatrixGraph() {
        graph = []
    }

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
                    graph << sublist
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

    public Map breadthFirstSearch(Integer rootVertex = 0) {
        def resultSequence = []

        def parents = []

        for (def i = 0; i < this.graphSize; i++)
            parents << null

        def bfsQueue = [] as Queue<Integer>

        bfsQueue << rootVertex
        resultSequence << rootVertex

        while (!bfsQueue.isEmpty()) {
            def vertex = bfsQueue.remove()
            def childVertexes = getChildVertices(vertex, this.graph)

            childVertexes.each { vNum ->
                if (!resultSequence.find() { it == vNum }) {
                    parents[vNum] = vertex

                    resultSequence << vNum
                    bfsQueue << vNum
                }
            }
        }

        return [seq: resultSequence as Integer[], parents: parents as Integer[]]
    }

    public List getChildVertices(Integer vertexNum, List graph) {
        def edges = graph[vertexNum]
        def vertexes = []

        edges.eachWithIndex { edge, i ->
            if (edge)
                vertexes << i
        }

        return vertexes
    }
}
