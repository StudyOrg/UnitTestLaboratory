package ru.niceone.math.tests

import org.junit.Assert
import org.junit.Test

import static ru.niceone.math.Math.log_2

class Logarithm2Test {
    final double PRECISION = 1E-9;

    /* Особые случаи */

    @Test
    public void nan() {
        Assert.assertEquals(Double.NaN, log_2(Double.NaN), PRECISION)
    }

    @Test
    public void positive_infinity() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, log_2(Double.POSITIVE_INFINITY), PRECISION)
    }

    @Test
    public void negative_infinity() {
        Assert.assertEquals(Double.NaN, log_2(Double.NEGATIVE_INFINITY), PRECISION)
    }

    /* Вне области определения функции */

    @Test
    public void negative() {
        Assert.assertEquals(Double.NaN, log_2(-1), PRECISION)
    }

    @Test
    public void near_zero_negative() {
        Assert.assertEquals(Double.NaN, log_2(-0.5), PRECISION)
    }

    @Test
    public void zero() {
        Assert.assertEquals(Double.NEGATIVE_INFINITY, log_2(0.0), PRECISION)
    }

    /* Внутри области определения функции */

    @Test
    public void near_zero_positive() {
        Assert.assertEquals(-1.0, log_2(0.5), PRECISION)
    }

    @Test
    public void near_one_less() {
        Assert.assertEquals(0.0, log_2(0.999999999999), PRECISION)
    }

    @Test
    public void one() {
        Assert.assertEquals(0.0, log_2(1.0), PRECISION)
    }

    @Test
    public void near_one_greater() {
        Assert.assertEquals(0.0, log_2(1.000000000001), PRECISION)
    }

    @Test
    public void near_base_less() {
        Assert.assertEquals(0.9999999999992786524795553379594399, log_2(2 - 0.000000000001), PRECISION)
    }

    @Test
    public void base() {
        Assert.assertEquals(1.0, log_2(2), PRECISION)
    }

    @Test
    public void near_base_greater() {
        Assert.assertEquals(1.00000000000072134752044430136679985, log_2(2 + 0.000000000001), PRECISION)
    }

    @Test
    public void above_one() {
        Assert.assertEquals(2.321928094887362347870319429489390175864831393024580612054, log_2(5), PRECISION)
    }
}
