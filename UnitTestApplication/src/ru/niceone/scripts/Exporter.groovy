package ru.niceone.scripts

import ru.niceone.math.Math
import ru.niceone.useless.FancyFunction

private static void exportFunction(Map args) {
    args.functions.each { fx ->
        def arguments = []
        def values = []
        for (double x = args.range.getFrom(); x <= args.range.getTo(); x += args.step) {
            arguments << x
            if (fx == "fancy")
                values = FancyFunction.calc(x)
            else
                values << Math."$fx"(x)
        }

        File export = new File("Results/fx_${fx}.csv")
        export.createNewFile()
        export.setText ""

        export << "x;"
        export << arguments.collect { val -> return val.toString().replace('.', ',') }.join(";")
        export << ";\n" << "$fx(x);"
        export << values.collect { val -> return val.toString().replace('.', ',') }.join(";")
    }
}

exportFunction range: (-30..30),
        step: 0.5,
        functions: ["sin", "cos", "tan", "cot", "sec", "csc", "fancy"]

exportFunction range: (0..30),
        step: 0.5,
        functions: ["ln", "log_2", "log_3", "log_5", "log_10"]

