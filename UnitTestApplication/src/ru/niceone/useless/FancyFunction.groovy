package ru.niceone.useless

import static ru.niceone.math.Math.*

public class FancyFunction {
    FancyFunction() {}

    private static double trigonometry(double x) {
        return (
                (
                        (
                                (
                                        ((((sec(x) * tan(x)) * sin(x)) ** 2) ** 3) /
                                        ((cos(x) + (csc(x) + csc(x))) * (cot(x) / sec(x)))
                                ) *
                                (
                                        (csc(x) - (sin(x) - cot(x))) + tan(x)
                                )
                        ) -
                        (
                                (
                                        (sec(x) ** 2) / sin(x)
                                ) +
                                (
                                        (sin(x) * sec(x)) * sec(x)
                                )
                        )
                ) /
                cos(x)
        )
    }

    public static double calc(double x) {
        return trigonometry(x)
    }
}
