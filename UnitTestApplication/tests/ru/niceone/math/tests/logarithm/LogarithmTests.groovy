package ru.niceone.math.tests.logarithm

import org.junit.Assert
import org.junit.Test

import static ru.niceone.math.Math.ln
import static ru.niceone.math.tests.Consts.PRECISION

class LogarithmTests {

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
    public void near_one_below() {
        Assert.assertEquals(0.0, ln(0.999999999999), PRECISION)
    }

    @Test
    public void one() {
        Assert.assertEquals(0.0, ln(1.0), PRECISION)
    }

    @Test
    public void near_one_above() {
        Assert.assertEquals(0.0, ln(1.000000000001), PRECISION)
    }

    @Test
    public void near_exp_below() {
        Assert.assertEquals(0.9999999999996321205588284900107628, ln(Math.E - 0.000000000001), PRECISION)
    }

    @Test
    public void exp() {
        Assert.assertEquals(1.0, ln(Math.E), PRECISION)
    }

    @Test
    public void near_exp_above() {
        Assert.assertEquals(1.000000000000367879441171374653953, ln(Math.E + 0.000000000001), PRECISION)
    }

    @Test
    public void above_one() {
        Assert.assertEquals(0.693147180559945309417232121458176568075500134360255254120, ln(2), PRECISION)
    }
}
