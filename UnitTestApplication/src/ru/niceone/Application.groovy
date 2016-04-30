package ru.niceone

import ru.niceone.math.Math
import ru.niceone.math.MathStubs
import ru.niceone.useless.FancyFunction

class Application {

    public static void main(argv) {

        final double begin = -java.lang.Math.PI * 3
        final double end = -begin

        final double step = java.lang.Math.PI / 16

        def arguments = []
        def values = []
        for (double x = begin; x <= end; x += step) {
            arguments << x
            //values << FancyFunction.calc(x)
            values << Math.cos(x)
        }

        println "Java cos   -> " + java.lang.Math.cos(1.5)
        println "Custom cos -> " + Math.cos(1.5)
        println "Stub cos   -> " + MathStubs.cos(1.5)

        println "Java ln   -> " + java.lang.Math.log(1.5)
        println "Custom ln -> " + Math.ln(1.5)
        println "Stub ln   -> " + MathStubs.ln(1.5)

        println "f -1.5 -> " + FancyFunction.calc(-3)
        println "f 0 -> " + FancyFunction.calc(0.0)
        println "f 1.5 -> " + FancyFunction.calc(3)
    }
}
