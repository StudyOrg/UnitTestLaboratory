package ru.niceone.math

class Math {
    public static long factorial(int n) {
        long ret = 1L
        for (int i = 2; i <= n; i++) ret *= i
        return ret
    }

    public static double cos(double x) {
        double sqrX = x * x
        double term = 1.0
        double sum = 1.0

        printf("x: [%.2f] ", x)

        for (int i = 1; i < 11; i++) {
            term *= sqrX / ((2*i - 1) * 2*i)

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
