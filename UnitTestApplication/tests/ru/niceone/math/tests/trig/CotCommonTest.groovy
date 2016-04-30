package ru.niceone.math.tests.trig

import org.junit.Assert
import org.junit.Test

import static ru.niceone.math.Math.cot
import static ru.niceone.math.tests.Consts.PRECISION

class CotCommonTest {

    @Test
    public void nan() {
        Assert.assertEquals(Double.NaN, cot(Double.NaN), PRECISION);
    }

    @Test
    public void negative_infinity() {
        Assert.assertEquals(Double.NaN, cot(Double.NEGATIVE_INFINITY), PRECISION);
    }

    @Test
    public void positive_infinity() {
        Assert.assertEquals(Double.NaN, cot(Double.POSITIVE_INFINITY), PRECISION);
    }

    @Test
    public void xy_symmetry() {
        Assert.assertEquals(-cot(5), cot(-5), PRECISION)
    }
}
