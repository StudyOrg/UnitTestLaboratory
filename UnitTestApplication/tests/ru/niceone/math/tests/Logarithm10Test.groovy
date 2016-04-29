package ru.niceone.math.tests

import org.junit.Assert
import org.junit.Test

import static ru.niceone.math.Math.log_10

class Logarithm10Test {
    final double PRECISION = 1E-9;

    /* Особые случаи */

    @Test
    public void nan() {
        Assert.assertEquals(Double.NaN, log_10(Double.NaN), PRECISION)
    }

    @Test
    public void positive_infinity() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, log_10(Double.POSITIVE_INFINITY), PRECISION)
    }

    @Test
    public void negative_infinity() {
        Assert.assertEquals(Double.NaN, log_10(Double.NEGATIVE_INFINITY), PRECISION)
    }

    /* Вне области определения функции */

    @Test
    public void negative() {
        Assert.assertEquals(Double.NaN, log_10(-1), PRECISION)
    }

    @Test
    public void near_zero_negative() {
        Assert.assertEquals(Double.NaN, log_10(-0.5), PRECISION)
    }

    @Test
    public void zero() {
        Assert.assertEquals(Double.NEGATIVE_INFINITY, log_10(0.0), PRECISION)
    }

    /* Внутри области определения функции */

    @Test
    public void near_zero_positive() {
        Assert.assertEquals(-0.30102999566398119521373889472449302676818988146210, log_10(0.5), PRECISION)
    }

    @Test
    public void near_one_less() {
        Assert.assertEquals(0.0, log_10(0.999999999999), PRECISION)
    }

    @Test
    public void one() {
        Assert.assertEquals(0.0, log_10(1.0), PRECISION)
    }

    @Test
    public void near_one_greater() {
        Assert.assertEquals(0.0, log_10(1.000000000001), PRECISION)
    }

    @Test
    public void near_base_less() {
        Assert.assertEquals(0.99999999999995657055180967264576, log_10(10 - 0.000000000001), PRECISION)
    }

    @Test
    public void base() {
        Assert.assertEquals(1.0, log_10(10), PRECISION)
    }

    @Test
    public void near_base_greater() {
        Assert.assertEquals(1.000000000000043429, log_10(10 + 0.000000000001), PRECISION)
    }

    @Test
    public void above_one() {
        Assert.assertEquals(0.301029995663981195213738894724493026768189881462108541310, log_10(2), PRECISION)
    }
}
