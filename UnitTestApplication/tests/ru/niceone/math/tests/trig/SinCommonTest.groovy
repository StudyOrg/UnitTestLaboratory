package ru.niceone.math.tests.trig

import org.junit.Assert
import org.junit.Test

import static ru.niceone.math.Math.sin
import static ru.niceone.math.tests.Consts.PRECISION

class SinCommonTest {

    @Test
    public void nan() {
        Assert.assertEquals(Double.NaN, sin(Double.NaN), PRECISION);
    }

    @Test
    public void negative_infinity() {
        Assert.assertEquals(Double.NaN, sin(Double.NEGATIVE_INFINITY), PRECISION);
    }

    @Test
    public void positive_infinity() {
        Assert.assertEquals(Double.NaN, sin(Double.POSITIVE_INFINITY), PRECISION);
    }

    @Test
    public void xy_symmetry() {
        Assert.assertEquals(-sin(5), sin(-5), PRECISION)
    }
}
