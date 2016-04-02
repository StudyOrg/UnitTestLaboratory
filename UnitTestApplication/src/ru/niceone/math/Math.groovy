package ru.niceone.math

class Math {
    public static double cos(double x) {
        if (x == Double.NEGATIVE_INFINITY || !(x < Double.POSITIVE_INFINITY))
            return Double.NaN;

        double sqrX = x * x
        double term = 1.0
        double sum = 1.0

        printf("x: [%.2f] ", x)

        for (int i = 1; term != 0.0; i++) {
            term *= sqrX / ((2 * i - 1) * 2 * i)

            if ((i % 2) == 1) {
                sum -= term
            } else {
                sum += term
            }

            printf("[%d] %.4f ", i, term)
        }
        println()

        return sum
    }

    public static double sec(double x) {
        return 1 / cos(x)
    }
}
