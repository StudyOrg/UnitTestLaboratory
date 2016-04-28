package ru.niceone.math.tests

import org.junit.Assert
import org.junit.Test

import static java.lang.Math.PI
import static ru.niceone.math.Math.cos

class CosTest {
    final double PRECISION = 1E-6;

    @Test
    public void nan() {
        Assert.assertEquals(Double.NaN, cos(Double.NaN), PRECISION);
    }

    @Test
    public void negative_infinity() {
        Assert.assertEquals(Double.NaN, cos(Double.NEGATIVE_INFINITY), PRECISION);
    }

    @Test
    public void positive_infinity() {
        Assert.assertEquals(Double.NaN, cos(Double.POSITIVE_INFINITY), PRECISION);
    }

    @Test
    public void near_zero_negative() {
        Assert.assertEquals(0.9999500004166652777, cos(-0.01), PRECISION);
    }

    @Test
    public void zero() {
        Assert.assertEquals(1.0, cos(0.0), PRECISION);
    }

    @Test
    public void near_zero_positive() {
        Assert.assertEquals(0.9999500004166652777, cos(0.01), PRECISION);
    }

    @Test
    public void near_half_PI_less() {
        Assert.assertEquals(0.00999983333416666468254243, cos(PI/2.0 - 0.01), PRECISION);
    }

    @Test
    public void half_PI() {
        Assert.assertEquals(Double.NaN, cos(PI/2.0), PRECISION);
    }

    @Test
    public void near_half_PI_greater() {
        Assert.assertNotEquals(-0.00999983333416666468254243, cos(PI/2.0 + 0.01), PRECISION);
    }
}
