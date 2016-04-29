package ru.niceone.math.tests.trig

import org.junit.Assert
import org.junit.Test

import static ru.niceone.math.Math.cos
import static ru.niceone.math.tests.Consts.PRECISION

class CosCommonTest {

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
    public void x_symmetry() {
        Assert.assertEquals(cos(5), cos(-5), PRECISION)
    }
}
