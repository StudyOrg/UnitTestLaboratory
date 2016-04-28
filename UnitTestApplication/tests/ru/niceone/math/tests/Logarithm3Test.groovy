package ru.niceone.math.tests

import org.junit.Assert
import org.junit.Test

import static ru.niceone.math.Math.log_3

class Logarithm3Test {
    final double PRECISION = 1E-9;

    /* Особые случаи */

    @Test
    public void nan() {
        Assert.assertEquals(Double.NaN, log_3(Double.NaN), PRECISION)
    }

    @Test
    public void positive_infinity() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, log_3(Double.POSITIVE_INFINITY), PRECISION)
    }

    @Test
    public void negative_infinity() {
        Assert.assertEquals(Double.NaN, log_3(Double.NEGATIVE_INFINITY), PRECISION)
    }

    /* Вне области определения функции */

    @Test
    public void negative() {
        Assert.assertEquals(Double.NaN, log_3(-1), PRECISION)
    }

    @Test
    public void near_zero_negative() {
        Assert.assertEquals(Double.NaN, log_3(-0.5), PRECISION)
    }

    @Test
    public void zero() {
        Assert.assertEquals(Double.NEGATIVE_INFINITY, log_3(0.0), PRECISION)
    }

    /* Внутри области определения функции */

    @Test
    public void near_zero_positive() {
        Assert.assertEquals(-0.6309297535714574370995271143427608542995, log_3(0.5), PRECISION)
    }

    @Test
    public void near_one_less() {
        Assert.assertEquals(0.0, log_3(0.999999999999), PRECISION)
    }

    @Test
    public void one() {
        Assert.assertEquals(0.0, log_3(1.0), PRECISION)
    }

    @Test
    public void near_one_greater() {
        Assert.assertEquals(0.0, log_3(1.000000000001), PRECISION)
    }

    @Test
    public void near_base_less() {
        Assert.assertEquals(0.9999999999996965869244576702999493, log_3(3 - 0.000000000001), PRECISION)
    }

    @Test
    public void base() {
        Assert.assertEquals(1.0, log_3(3), PRECISION)
    }

    @Test
    public void near_base_greater() {
        Assert.assertEquals(1.0000000000003034130755422285623588230, log_3(3 + 0.000000000001), PRECISION)
    }

    @Test
    public void above_one() {
        Assert.assertEquals(0.630929753571457437099527114342760854299585640131880427870, log_3(2), PRECISION)
    }
}
