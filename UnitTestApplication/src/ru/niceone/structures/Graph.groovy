package ru.niceone.structures

public class Graph<T> {
    private List<List<T>> graph
    private Integer graphSize

    public Graph() {
        graph = []
    }

    public void loadFromFile(File file) {
        file.eachLine { line ->
            def sublist = []

            if (line) {
                line = line.tokenize(" ")

                line.each { edge ->
                    sublist << edge.equals("1")
                }

                graph << sublist
            }

            graphSize = sublist.size()
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
