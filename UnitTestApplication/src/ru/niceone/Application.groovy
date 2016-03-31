package ru.niceone

import ru.niceone.structures.MatrixGraph

class Application {

    private static final String JSON = "Datasets/data.json";

    public static void main(args) {
        File matrixVerticesJson = new File(JSON)

        MatrixGraph<String> g = new MatrixGraph<>()
        //g.loadFromJson(matrixVerticesJson)

        g.setGraph(["X", "Y", "Z"], [[0, 1, 1], [1, 0, 0], [1, 0, 0]])

        def result = g.breadthFirstSearch("Y")

        if (result.founded) {
            println "Founded at " + (result.path == [0] ? "beginning" : result.path)
        } else {
            println "Not founded, path " + result.path
        }
    }
}
