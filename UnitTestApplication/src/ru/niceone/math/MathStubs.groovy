package ru.niceone.math

public class MathStubs {
    private static final Double PRECISION = 1E-10;

    private MathStubs() {
    }

    public static double cos(double x) {
        Map<Double, Double> table = [
                (-3.0): -0.989992496600445,
                (-2.5): -0.801143615546934,
                (-2.0): -0.416146836547142,
                (-1.5): 0.0707372016677029,
                (-1.0): 0.54030230586814,
                (-0.5): 0.877582561890373,
                (-0.0): 1.0,
                (0.0) : 1.0,
                (0.5) : 0.877582561890373,
                (1.0) : 0.54030230586814,
                (1.5) : 0.0707372016677029,
                (2.0) : -0.416146836547142,
                (2.5) : -0.801143615546934,
                (3.0) : -0.989992496600445
        ]

        return table[x as BigDecimal]
    }

    public static double cot(double x) {
        Map<Double, Double> table = [
                (-3.0): 7.01525255143453,
                (-2.5): 1.33864812830415,
                (-2.0): 0.457657554360286,
                (-1.5): -0.0709148443026524,
                (-1.0): -0.642092615934331,
                (-0.5): -1.83048772171245,
                (-0.0): Double.NEGATIVE_INFINITY,
                (0.0) : Double.POSITIVE_INFINITY,
                (0.5) : 1.83048772171245,
                (1.0) : 0.642092615934331,
                (1.5) : 0.0709148443026524,
                (2.0) : -0.457657554360286,
                (2.5) : -1.33864812830415,
                (3.0) : -7.01525255143453
        ]

        return table[x as BigDecimal]
    }

    public static double csc(double x) {
        Map<Double, Double> table = [
                (-3.0): -7.08616739573719,
                (-2.5): -1.67092154555868,
                (-2.0): -1.09975017029462,
                (-1.5): -1.00251130424672,
                (-1.0): -1.18839510577812,
                (-0.5): -2.08582964293349,
                (-0.0): Double.NEGATIVE_INFINITY,
                (0.0) : Double.POSITIVE_INFINITY,
                (0.5) : 2.08582964293349,
                (1.0) : 1.18839510577812,
                (1.5) : 1.00251130424672,
                (2.0) : 1.09975017029462,
                (2.5) : 1.67092154555868,
                (3.0) : 7.08616739573719
        ]

        return table[x as BigDecimal]
    }

    public static double sin(double x) {
        Map<Double, Double> table = [
                (-3.0): -0.141120008059867,
                (-2.5): -0.598472144103957,
                (-2.0): -0.909297426825682,
                (-1.5): -0.997494986604054,
                (-1.0): -0.841470984807897,
                (-0.5): -0.479425538604203,
                (-0.0): -0.0,
                (0.0) : 0.0,
                (0.5) : 0.479425538604203,
                (1.0) : 0.841470984807897,
                (1.5) : 0.997494986604054,
                (2.0) : 0.909297426825682,
                (2.5) : 0.598472144103957,
                (3.0) : 0.141120008059867
        ]

        return table[x as BigDecimal]
    }

    public static double sec(double x) {
        Map<Double, Double> table = [
                (-3.0): -1.01010866590799,
                (-2.5): -1.24821565146882,
                (-2.0): -2.40299796172238,
                (-1.5): 14.1368329029699,
                (-1.0): 1.85081571768093,
                (-0.5): 1.13949392732455,
                (-0.0): 1.0,
                (0.0) : 1.0,
                (0.5) : 1.13949392732455,
                (1.0) : 1.85081571768093,
                (1.5) : 14.1368329029699,
                (2.0) : -2.40299796172238,
                (2.5) : -1.24821565146882,
                (3.0) : -1.01010866590799
        ]

        return table[x as BigDecimal]
    }

    public static double tan(double x) {
        Map<Double, Double> table = [
                (-3.0): 0.142546543074278,
                (-2.5): 0.74702229723866,
                (-2.0): 2.18503986326152,
                (-1.5): -14.1014199471717,
                (-1.0): -1.5574077246549,
                (-0.5): -0.54630248984379,
                (-0.0): -0.0,
                (0.0) : 0.0,
                (0.5) : 0.54630248984379,
                (1.0) : 1.5574077246549,
                (1.5) : 14.1014199471717,
                (2.0) : -2.18503986326152,
                (2.5) : -0.74702229723866,
                (3.0) : -0.142546543074278
        ]

        return table[x as BigDecimal]
    }

    public static double ln(double x) {
        Map<Double, Double> table = [
                (-3.0): Double.NaN,
                (-2.5): Double.NaN,
                (-2.0): Double.NaN,
                (-1.5): Double.NaN,
                (-1.0): Double.NaN,
                (-0.5): Double.NaN,
                (-0.0): Double.NaN,
                (0.0) : Double.NaN,
                (0.5) : -0.693147180559945,
                (1.0) : 0,
                (1.5) : 0.405465108108164,
                (2.0) : 0.693147180559945,
                (2.5) : 0.916290731874155,
                (3.0) : 1.09861228866811
        ]

        return table[x as BigDecimal]
    }

    public static double log_2(double x) {
        Map<Double, Double> table = [
                (-3.0): Double.NaN,
                (-2.5): Double.NaN,
                (-2.0): Double.NaN,
                (-1.5): Double.NaN,
                (-1.0): Double.NaN,
                (-0.5): Double.NaN,
                (-0.0): Double.NaN,
                (0.0) : Double.NaN,
                (0.5) : -1,
                (1.0) : 0,
                (1.5) : 0.584962500721156,
                (2.0) : 1,
                (2.5) : 1.32192809488736,
                (3.0) : 1.58496250072116
        ]

        return table[x as BigDecimal]
    }

    public static double log_3(double x) {
        Map<Double, Double> table = [
                (-3.0): Double.NaN,
                (-2.5): Double.NaN,
                (-2.0): Double.NaN,
                (-1.5): Double.NaN,
                (-1.0): Double.NaN,
                (-0.5): Double.NaN,
                (-0.0): Double.NaN,
                (0.0) : Double.NaN,
                (0.5) : -0.630929753571457,
                (1.0) : 0,
                (1.5) : 0.369070246428543,
                (2.0) : 0.630929753571457,
                (2.5) : 0.83404376714647,
                (3.0) : 1
        ]

        return table[x as BigDecimal]
    }

    public static double log_5(double x) {
        Map<Double, Double> table = [
                (-3.0): Double.NaN,
                (-2.5): Double.NaN,
                (-2.0): Double.NaN,
                (-1.5): Double.NaN,
                (-1.0): Double.NaN,
                (-0.5): Double.NaN,
                (-0.0): Double.NaN,
                (0.0) : Double.NaN,
                (0.5) : -0.430676558073393,
                (1.0) : 0,
                (1.5) : 0.251929636412592,
                (2.0) : 0.430676558073393,
                (2.5) : 0.569323441926607,
                (3.0) : 0.682606194485985
        ]

        return table[x as BigDecimal]
    }

    public static double log_10(double x) {
        Map<Double, Double> table = [
                (-3.0): Double.NaN,
                (-2.5): Double.NaN,
                (-2.0): Double.NaN,
                (-1.5): Double.NaN,
                (-1.0): Double.NaN,
                (-0.5): Double.NaN,
                (-0.0): Double.NaN,
                (0.0) : Double.NaN,
                (0.5) : -0.301029995663981,
                (1.0) : 0,
                (1.5) : 0.176091259055681,
                (2.0) : 0.301029995663981,
                (2.5) : 0.397940008672038,
                (3.0) : 0.477121254719662
        ]

        return table[x as BigDecimal]
    }

}
