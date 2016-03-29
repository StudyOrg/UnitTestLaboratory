package ru.niceone

import ru.niceone.structures.Graph

class Application {

    private static final String PATH = "C:\\Users\\roman\\Code\\UnitTestLaboratory\\UnitTestApplication\\other\\matrix.txt";

    public static void main(args) {
        File matrixVertices = new File(PATH)

        Graph<Boolean> g = new Graph<>()
        g.loadFromFile(matrixVertices)

        println(g.breadthFirstSearch().parents.join(", "))
    }
}
