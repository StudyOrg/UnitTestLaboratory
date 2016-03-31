package ru.niceone

import ru.niceone.structures.MatrixGraph

class Application {

    private static final String JSON = "Datasets/data.json";

    public static void main(args) {
        File matrixVerticesJson = new File(JSON)

        MatrixGraph<String> g = new MatrixGraph<>()
        g.loadFromJson(matrixVerticesJson)

        def result = g.breadthFirstSearch("G")

        if (result.founded) {
            println "Founded at " + (result.path == [0] ? "beginning" : result.path)
        } else {
            println "Not founded, path " + result.path
        }
    }
}
