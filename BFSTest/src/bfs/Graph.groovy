package bfs

class Graph {
    public List<List<Boolean>> graph;
    public Integer graphSize;

    private static final String PATH = "D:\\tests\\UnitTestLaboratory\\BFSTest\\other\\matrix.txt";

    public Graph() {
        graph = [];

        new File(PATH).eachLine { line ->
            def sublist = [];

            if (line) {
                line = line.tokenize(" ");

                line.each { edge ->
                    sublist << edge.equals("1");
                }

                graph << sublist
            }

            graphSize = sublist.size();
        }
    }
}
