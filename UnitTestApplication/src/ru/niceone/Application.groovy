package ru.niceone

import ru.niceone.structures.MatrixGraph

class Application {

    private static final String PATH = "Datasets/matrix.txt";

    public static void main(args) {
        File matrixVertices = new File(PATH)

        MatrixGraph g = new MatrixGraph<>()
        g.loadFromFile(matrixVertices)

        println(g.breadthFirstSearch().parents.join(", "))
    }
}
