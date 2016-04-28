package ru.niceone.math;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Math {
    private Math() {
    }

    /**
     * <p><b>Тригонометрические функции</b></p>
     * <p>
     * <p>Функция, вычисляющая значение коснуса угла через функцию синуса.</p>
     * <p>Особые случаи:</p>
     * <ul><li>Если аргумент равен NaN или infinity, то функция возвращает NaN</li></ul>
     *
     * @param x угол, в радианах
     * @return косинус аргумента
     */
    public static double cos(double x) {
        double sqrCosX = 1 - pow(sin(x), 2);
        return sqrt(sqrCosX);
    }

    /**
     * <p>Функция, вычисляющая значение котангенса угла через функции синуса и косинуса.</p>
     * <p>Особые случаи:</p>
     * <ul><li>Если аргумент равен NaN или infinity, то функция возвращает NaN</li></ul>
     *
     * @param x угол, в радианах
     * @return котангенс аргумента
     */
    public static double cot(double x) {
        return cos(x) / sin(x);
    }

    /**
     * <p>Функция, вычисляющая значение косеканса угла через функцию синуса.</p>
     * <p>Особые случаи:</p>
     * <ul><li>Если аргумент равен NaN или infinity, функция возвращает NaN</li>
     * <li>Если аргумент равен 0, функция возвращает NaN</li></ul>
     *
     * @param x угол, в радианах
     * @return косеканс аргумента
     */
    public static double csc(double x) {
        return 1 / sin(x);
    }

    /**
     * <p>Функция, вычисляющая значение синуса угла методом разложения в ряд Тейлора.</p>
     * <p>Особые случаи:</p>
     * <ul><li>Если аргумент равен NaN или infinity, то функция возвращает NaN</li></ul>
     *
     * @param x угол, в радианах
     * @return синус аргумента
     */
    public static double sin(double x) {
        if (x == Double.NEGATIVE_INFINITY || !(x < Double.POSITIVE_INFINITY))
            return Double.NaN;

        double sqrX = pow(x, 2);
        double term = x;
        double sum = x;

        for (int i = 1; term > 0.0 && i != Integer.MAX_VALUE; i++) {
            term *= sqrX / ((2 * i + 1) * 2 * i);

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
     * <ul><li>Если аргумент равен NaN или infinity, функция возвращает NaN</li>
     * <li>Если аргумент равен 0, функция возвращает NaN</li></ul>
     *
     * @param x угол, в радианах
     * @return секанс угла
     */
    public static double sec(double x) {
        return 1 / cos(x);
    }

    /**
     * <p>Функция, вычисляющая значение тангенса угла через функции синуса и косинуса.</p>
     * <p>Особые случаи:</p>
     * <ul><li>Если аргумент равен NaN или infinity, то функция возвращает NaN</li></ul>
     *
     * @param x угол, в радианах
     * @return тангенс аргумента
     */
    public static double tan(double x) {
        return sin(x) / cos(x);
    }


    /**
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
     * <p>Функция, вычисляющая логарифм числа по основанию 2.</p>
     * <p>Особые случаи:</p>
     * <ul><li>Если аргумент равен NaN или -infinity, функция возвращает NaN</li>
     * <li>Если аргумент равен infinity, функция возвращает infinity</li>
     * <li>Если аргумент меньше или равен 0, функция возвращает NaN</li>
     * <li>Если основание меньше или равен 0, функция возвращает NaN</li></ul>
     *
     * @param x логарифмируемое число
     * @return показатель степени
     */
    public static double log_2(double x) {
        return (ln(x) / ln(2));
    }

    /**
     * <p>Функция, вычисляющая логарифм числа по основанию 3.</p>
     * <p>Особые случаи:</p>
     * <ul><li>Если аргумент равен NaN или -infinity, функция возвращает NaN</li>
     * <li>Если аргумент равен infinity, функция возвращает infinity</li>
     * <li>Если аргумент меньше или равен 0, функция возвращает NaN</li>
     * <li>Если основание меньше или равен 0, функция возвращает NaN</li></ul>
     *
     * @param x логарифмируемое число
     * @return показатель степени
     */
    public static double log_3(double x) {
        return (ln(x) / ln(3));
    }

    /**
     * <p>Функция, вычисляющая логарифм числа по основанию 5.</p>
     * <p>Особые случаи:</p>
     * <ul><li>Если аргумент равен NaN или -infinity, функция возвращает NaN</li>
     * <li>Если аргумент равен infinity, функция возвращает infinity</li>
     * <li>Если аргумент меньше или равен 0, функция возвращает NaN</li>
     * <li>Если основание меньше или равен 0, функция возвращает NaN</li></ul>
     *
     * @param x логарифмируемое число
     * @return показатель степени
     */
    public static double log_5(double x) {
        return (ln(x) / ln(5));
    }

    /**
     * <p>Функция, вычисляющая логарифм числа по основанию 10.</p>
     * <p>Особые случаи:</p>
     * <ul><li>Если аргумент равен NaN или -infinity, функция возвращает NaN</li>
     * <li>Если аргумент равен infinity, функция возвращает infinity</li>
     * <li>Если аргумент меньше или равен 0, функция возвращает NaN</li>
     * <li>Если основание меньше или равен 0, функция возвращает NaN</li></ul>
     *
     * @param x логарифмируемое число
     * @return показатель степени
     */
    public static double log_10(double x) {
        return (ln(x) / ln(10));
    }
}
