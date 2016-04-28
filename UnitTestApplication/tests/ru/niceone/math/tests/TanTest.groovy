package ru.niceone.math.tests

import org.junit.Assert
import org.junit.Test

import static java.lang.Math.PI
import static ru.niceone.math.Math.tan

class TanTest {
    final double PRECISION = 1E-6;

    @Test
    public void nan() {
        Assert.assertEquals(Double.NaN, tan(Double.NaN), PRECISION);
    }

    @Test
    public void negative_infinity() {
        Assert.assertEquals(Double.NaN, tan(Double.NEGATIVE_INFINITY), PRECISION);
    }

    @Test
    public void positive_infinity() {
        Assert.assertEquals(Double.NaN, tan(Double.POSITIVE_INFINITY), PRECISION);
    }

    @Test
    public void near_zero_negative() {
        Assert.assertEquals(-0.0100003333466672063710767241019, tan(-0.01), PRECISION);
    }

    @Test
    public void zero() {
        Assert.assertEquals(0.0, tan(0.0), PRECISION);
    }

    @Test
    public void near_zero_positive() {
        Assert.assertEquals(0.0100003333466672063710767241019, tan(0.01), PRECISION);
    }

    @Test
    public void near_half_PI_less() {
        Assert.assertEquals(99.9966666444442328021163807383, tan(PI/2.0 - 0.01), PRECISION);
    }

    @Test
    public void half_PI() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, tan(PI/2.0), PRECISION);
    }

    @Test
    public void near_half_PI_greater() {
        Assert.assertNotEquals(-99.9966666444442328021163807383, tan(PI/2.0 + 0.01), PRECISION);
    }
}
