package ru.niceone

import ru.niceone.math.Math
import ru.niceone.useless.FancyFunction
import ru.niceone.util.Arrays

class Application {

    public static void main(argv) {

        final double begin = -30
        final double end = -begin

        println FancyFunction.calc(5)

        final double step = 1.0

        def arguments = []
        def customSecCalc = []
        def javaSecCalc = []
        for (double x = begin; x <= end; x += step) {
            arguments << x
            customSecCalc << Math.sec(x)
            javaSecCalc << 1 / java.lang.Math.cos(x)
        }

        printf "sec(PI/2) is    %f\n", Math.sec(java.lang.Math.PI / 2)
        printf "sec(NaN) is     %f\n", Math.sec(Double.NaN)
        printf "sec(0) is       %f\n", Math.sec(0)
        printf "sec(20) is      %f\n", Math.sec(20)
        printf "sec(-30) is     %f\n", Math.sec(-30)

        File export = new File("Results/sec_compare.csv")
        export.setText ""

        export << "x;"
        export << arguments.collect { val -> return val.toString().replace('.', ',') }.join(";")
        export << ";\n" << "Custom sec(x);"
        export << customSecCalc.collect { val -> return val.toString().replace('.', ',') }.join(";")
        export << ";\n" << "Lib sec(x);"
        export << javaSecCalc.collect { val -> return val.toString().replace('.', ',') }.join(";")
        export << ";\n" << "Diff;"
        export << Arrays.operate(customSecCalc, javaSecCalc, { a, b -> a - b }).collect { val -> return val.toString().replace('.', ',') }.join(";")

        File table = new File("Results/table.txt")
        table.setText ""

        table << "static final Object[][] set = {\n"
        for(double x = begin; x <= end; x += step) {
            table << "    { ${x}, ${1 / java.lang.Math.cos(x)} },\n"
        }
        table << "};"
    }
}
