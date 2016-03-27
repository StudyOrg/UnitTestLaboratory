package bfs

class BfsMain {

    public static void main(args) {
        Graph g = new Graph();
        println(bfs(g, 0).parents.join(", "));
    }

    public static Map bfs(Graph graph, Integer rootVertex) {
        def resultSequence = [];

        def parents = []

        for (def i = 0; i < graph.graphSize; i++)
            parents << null

        def bfsQueue = [] as Queue<Integer>;

        bfsQueue << rootVertex;
        resultSequence << rootVertex;

        while (!bfsQueue.isEmpty()) {
            def vertex = bfsQueue.remove();
            def childVertexes = getChildVertexes(vertex, graph.graph);

            childVertexes.each { vNum ->
                if (!resultSequence.find() { it == vNum }) {
                    parents[vNum] = vertex;

                    resultSequence << vNum;
                    bfsQueue << vNum;
                }
            }
        }

        return [seq: resultSequence as Integer[], parents: parents as Integer[]];
    }

    public static List getChildVertexes(Integer vertexNum, List graph) {
        def edges = graph[vertexNum];
        def vertexes = [];

        def i = 0;

        edges.each { edge ->
            if (edge)
                vertexes << i;

            i++;
        }

        return vertexes;
    }
}
