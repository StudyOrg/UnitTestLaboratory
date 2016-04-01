package ru.niceone

import ru.niceone.math.Math
import ru.niceone.structures.MatrixGraph

class Application {

    private static final String JSON = "Datasets/data.json";

    public static void main(args) {
        File matrixVerticesJson = new File(JSON)

        MatrixGraph<String> g = new MatrixGraph<>()

        g.setGraph(["X", "Y", "Z"], [[0, 1, 1], [1, 0, 0], [1, 0, 0]])

        def result = g.breadthFirstSearch("Y")

        if (result.founded) {
            println "Founded at " + (result.path == [0] ? "beginning" : result.path)
        } else {
            println "Not founded, path " + result.path
        }

        g.loadFromJson(matrixVerticesJson)

        result = g.breadthFirstSearch("L")

        if (result.founded) {
            println "Founded at " + (result.path == [0] ? "beginning" : result.path)
        } else {
            println "Not founded, path " + result.path
        }

        ArrayList<Double> cosResults = new ArrayList<>()
        for (double x = 0.0; x < 2.0; x += 0.1) {
            cosResults << Math.cos(x)
        }

        print(cosResults.join(";"))
    }
}
