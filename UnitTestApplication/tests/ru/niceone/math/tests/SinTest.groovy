package ru.niceone.math.tests

import org.junit.Assert
import org.junit.Test

import static java.lang.Math.PI
import static ru.niceone.math.Math.sin

class SinTest {
    final double PRECISION = 1E-6;

    @Test
    public void nan() {
        Assert.assertTrue(Double.isNaN(sin(Double.NaN)));
    }

    @Test
    public void negative_infinity() {
        Assert.assertTrue(Double.isNaN(sin(Double.NEGATIVE_INFINITY)));
    }

    @Test
    public void positive_infinity() {
        Assert.assertTrue(Double.isNaN(sin(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void near_zero_negative() {
        Assert.assertEquals(-0.009999833334166664682542438269099, sin(-0.01), PRECISION);
    }

    @Test
    public void zero() {
        Assert.assertEquals(0.0, sin(0.0), PRECISION);
    }

    @Test
    public void near_zero_positive() {
        Assert.assertEquals(0.009999833334166664682542438269099, sin(0.01), PRECISION);
    }

    @Test
    public void near_HalfPI_less() {
        Assert.assertEquals(0.9999500004166652777802579337522066732, sin(PI/2.0 - 0.01), PRECISION);
    }

    @Test
    public void HalfPI() {
        Assert.assertEquals(1.0, sin(PI/2.0), PRECISION);
    }

    @Test
    public void near_HalfPI_greater() {
        Assert.assertEquals(0.9999500004166652777802579337522066732, sin(PI/2.0 + 0.01), PRECISION);
    }
}
