package ru.niceone.math.tests.trig

import org.junit.Assert
import org.junit.Test

import static ru.niceone.math.Math.sec
import static ru.niceone.math.tests.Consts.PRECISION

class SecCommonTest {

    @Test
    public void nan() {
        Assert.assertEquals(Double.NaN, sec(Double.NaN), PRECISION);
    }

    @Test
    public void negative_infinity() {
        Assert.assertEquals(Double.NaN, sec(Double.NEGATIVE_INFINITY), PRECISION);
    }

    @Test
    public void positive_infinity() {
        Assert.assertEquals(Double.NaN, sec(Double.POSITIVE_INFINITY), PRECISION);
    }

    @Test
    public void x_symmetry() {
        Assert.assertEquals(sec(5), sec(-5), PRECISION)
    }
}
