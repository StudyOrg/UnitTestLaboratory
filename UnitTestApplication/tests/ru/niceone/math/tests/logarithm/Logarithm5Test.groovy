package ru.niceone.math.tests.logarithm

import org.junit.Assert
import org.junit.Test

import static ru.niceone.math.Math.log_5
import static ru.niceone.math.tests.Consts.PRECISION

class Logarithm5Test {

    /* Особые случаи */

    @Test
    public void nan() {
        Assert.assertEquals(Double.NaN, log_5(Double.NaN), PRECISION)
    }

    @Test
    public void positive_infinity() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, log_5(Double.POSITIVE_INFINITY), PRECISION)
    }

    @Test
    public void negative_infinity() {
        Assert.assertEquals(Double.NaN, log_5(Double.NEGATIVE_INFINITY), PRECISION)
    }

    /* Вне области определения функции */

    @Test
    public void negative() {
        Assert.assertEquals(Double.NaN, log_5(-1), PRECISION)
    }

    @Test
    public void near_zero_negative() {
        Assert.assertEquals(Double.NaN, log_5(-0.5), PRECISION)
    }

    @Test
    public void zero() {
        Assert.assertEquals(Double.NEGATIVE_INFINITY, log_5(0.0), PRECISION)
    }

    /* Внутри области определения функции */

    @Test
    public void near_zero_positive() {
        Assert.assertEquals(-0.430676558073393050670106568763965632069, log_5(0.5), PRECISION)
    }

    @Test
    public void near_one_below() {
        Assert.assertEquals(0.0, log_5(0.999999999999), PRECISION)
    }

    @Test
    public void one() {
        Assert.assertEquals(0.0, log_5(1.0), PRECISION)
    }

    @Test
    public void near_one_above() {
        Assert.assertEquals(0.0, log_5(1.000000000001), PRECISION)
    }

    @Test
    public void near_base_below() {
        Assert.assertEquals(0.99999999999987573301308806521115986892, log_5(5 - 0.000000000001), PRECISION)
    }

    @Test
    public void base() {
        Assert.assertEquals(1.0, log_5(5), PRECISION)
    }

    @Test
    public void near_base_above() {
        Assert.assertEquals(1.00000000000012426698691190993544274868705, log_5(5 + 0.000000000001), PRECISION)
    }

    @Test
    public void above_one() {
        Assert.assertEquals(0.430676558073393050670106568763965632069791932079760449321, log_5(2), PRECISION)
    }
}
