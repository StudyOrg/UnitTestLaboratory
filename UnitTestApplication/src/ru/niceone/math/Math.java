package ru.niceone.math;

public class Math {
    private Math() {}

    /**
     * <p>Функция, вычисляющая значение коснуса угла методом разложения в ряд Тейлора.</p>
     * <p>Особые случаи:</p>
     * <ul><li>Если аргумент равен NaN или infinity, то функция возвращает NaN</ul>
     *
     * @param x угол, в радианах
     * @return косинус аргумента
     */
    public static double cos(double x) {
        if (x == Double.NEGATIVE_INFINITY || !(x < Double.POSITIVE_INFINITY))
            return Double.NaN;

        double sqrX = x * x;
        double term = 1.0;
        double sum = 1.0;

        for (int i = 1; term > 0.0 && i != Integer.MAX_VALUE; i++) {
            term *= sqrX / ((2 * i - 1) * 2 * i);

            if ((i % 2) == 1) {
                sum -= term;
            } else {
                sum += term;
            }
        }

        return sum;
    }

    /**
     * <p>Функция, вычисляющая значения секанса угла.</p>
     * <p>Особые случаи:</p>
     * <ul><li>Если аргумент равен NaN или infinity, функция возвращает NaN
     * <li>Если аргумент равен 0, функция возвращает NaN</ul>
     *
     * @param x угол, в радианах
     * @return секанс угла
     */
    public static double sec(double x) {
        return 1 / cos(x);
    }
}
