package ru.niceone.math;

public class Logarithm {
    private Logarithm() {}

    /**
     * <p><b>Логарифмы</b></p>
     *
     * <p>Функция, вычисляющая натуральный логарифм числа.</p>
     * <p>Особые случаи:</p>
     * <ul><li>Если аргумент равен NaN или -infinity, функция возвращает NaN</li>
     * <li>Если аргумент равен infinity, функция возвращает infinity</li>
     * <li>Если аргумент меньше или равен 0, функция возвращает NaN</li></ul>
     *
     * @param x логарифмируемое число
     * @return показатель степени
     */
    public static double ln(double x) {
        if (x == Double.NEGATIVE_INFINITY || x <= 0)
            return Double.NaN;
        else if (!(x < Double.POSITIVE_INFINITY))
            return Double.POSITIVE_INFINITY;

        double nominator = x - 1;
        double term = nominator;
        double sum = term;

        for (int i = 2; term > 0.0 && i != Integer.MAX_VALUE; i++) {
            term *= nominator / i;

            if ((i % 2) == 0) {
                sum -= term;
            } else {
                sum += term;
            }
        }

        return sum;
    }

    /**
     * <p>Функция, вычисляющая логарифм числа по произвольнму основанию.</p>
     * <p>Особые случаи:</p>
     * <ul><li>Если аргумент равен NaN или -infinity, функция возвращает NaN</li>
     * <li>Если аргумент равен infinity, функция возвращает infinity</li>
     * <li>Если аргумент меньше или равен 0, функция возвращает NaN</li>
     * <li>Если основание меньше или равен 0, функция возвращает NaN</li></ul>
     *
     * @param x логарифмируемое число
     * @param base основание логарифма
     * @return показатель степени
     */
    public static double log(double x, double base) {
        if (base == Double.NEGATIVE_INFINITY || base <= 0)
            return Double.NaN;
        else if (!(base < Double.POSITIVE_INFINITY))
            return Double.POSITIVE_INFINITY;

        return (ln(x)/ln(base));
    }
}
