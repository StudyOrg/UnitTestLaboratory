package ru.niceone.math.tests

import org.junit.Assert
import org.junit.Test

import static ru.niceone.math.Math.ln

class LogarithmTests {
    final double PRECISION = 1E-9;

    /* Особые случаи */

    @Test
    public void nan() {
        Assert.assertEquals(Double.NaN, ln(Double.NaN), PRECISION)
    }

    @Test
    public void positive_infinity() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, ln(Double.POSITIVE_INFINITY), PRECISION)
    }

    @Test
    public void negative_infinity() {
        Assert.assertEquals(Double.NaN, ln(Double.NEGATIVE_INFINITY), PRECISION)
    }

    /* Вне области определения функции */

    @Test
    public void negative() {
        Assert.assertEquals(Double.NaN, ln(-1), PRECISION)
    }

    @Test
    public void near_zero_negative() {
        Assert.assertEquals(Double.NaN, ln(-0.5), PRECISION)
    }

    @Test
    public void zero() {
        Assert.assertEquals(Double.NEGATIVE_INFINITY, ln(0.0), PRECISION)
    }

    /* Внутри области определения функции */

    @Test
    public void near_zero_positive() {
        Assert.assertEquals(-0.69314718055994530941723212145817656807550013436025, ln(0.5), PRECISION)
    }

    @Test
    public void between_zero_and_one_exclusive() {
        Assert.assertEquals(-0.69314718055994530941723212145817656807550013436025, ln(0.5), PRECISION)
    }

    @Test
    public void near_one_less() {
        Assert.assertEquals(0.0, ln(0.999999999999), PRECISION)
    }

    @Test
    public void one() {
        Assert.assertEquals(0.0, ln(1.0), PRECISION)
    }

    @Test
    public void near_one_greater() {
        Assert.assertEquals(0.0, ln(1.000000000001), PRECISION)
    }

    @Test
    public void near_exp_less() {
        Assert.assertEquals(1.0, ln(Math.E) - 0.000000000001, PRECISION)
    }

    @Test
    public void exp() {
        Assert.assertEquals(1.0, ln(Math.E), PRECISION)
    }

    @Test
    public void near_exp_greater() {
        Assert.assertEquals(1.0, ln(Math.E) + 0.000000000001, PRECISION)
    }

    @Test
    public void above_one() {
        Assert.assertEquals(0.693147180559945309417232121458176568075500134360255254120, ln(2), PRECISION)
    }
}
