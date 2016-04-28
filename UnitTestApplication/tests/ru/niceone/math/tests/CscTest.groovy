package ru.niceone.math.tests

import org.junit.Assert
import org.junit.Test

import static java.lang.Math.PI
import static ru.niceone.math.Math.csc

class CscTest {
    final double PRECISION = 1E-6;

    @Test
    public void nan() {
        Assert.assertEquals(Double.NaN, csc(Double.NaN), PRECISION);
    }

    @Test
    public void negative_infinity() {
        Assert.assertEquals(Double.NaN, csc(Double.NEGATIVE_INFINITY), PRECISION);
    }

    @Test
    public void positive_infinity() {
        Assert.assertEquals(Double.NaN, csc(Double.POSITIVE_INFINITY), PRECISION);
    }

    @Test
    public void near_zero_negative() {
        Assert.assertEquals(-100.00166668611131613966602662726726, csc(-0.01), 1E-1);
    }

    @Test
    public void zero() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, csc(0.0), PRECISION);
    }

    @Test
    public void near_zero_positive() {
        Assert.assertEquals(100.00166668611131613966602662726726, csc(0.01), PRECISION);
    }

    @Test
    public void near_half_PI_less() {
        Assert.assertEquals(1.0000500020834180589907146248, csc(PI/2.0 - 0.01), PRECISION);
    }

    @Test
    public void half_PI() {
        Assert.assertEquals(1.0, csc(PI/2.0), PRECISION);
    }

    @Test
    public void near_half_PI_greater() {
        Assert.assertNotEquals(-1.0000500020834180589907146248, csc(PI/2.0 + 0.01), PRECISION);
    }
}
