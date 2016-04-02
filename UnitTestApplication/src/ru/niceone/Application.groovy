package ru.niceone

import ru.niceone.math.Math
import ru.niceone.structures.MatrixGraph
import ru.niceone.util.Arrays

class Application {

    private static final String JSON = "Datasets/data.json"

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

        double from = 0.0
        double to = 80.0
        double step = 2

        def customCosineCalc = []
        for (double x = from; x < to; x += step) {
            double a = Math.cos(x)
            customCosineCalc << a
        }

        def javaCosineCalc = []
        for (double x = from; x < to; x += step) {
            double a = java.lang.Math.cos(x)
            javaCosineCalc << a
        }

        File export = new File("Results/cosine_compare.csv")
        export.setText("")

        export << "Custom cos(x);"
        export << customCosineCalc.collect { val -> return val.toString().replace('.', ',') }.join(";")
        export << ";\n" << "Lib cos(x);"
        export << javaCosineCalc.collect { val -> return val.toString().replace('.', ',') }.join(";")
        export << ";\n" << "Diff;"
        export << Arrays.operate(customCosineCalc, javaCosineCalc, { a, b -> a - b}).collect { val -> return val.toString().replace('.', ',') }.join(";")
    }
}
