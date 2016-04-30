package ru.niceone.math.tests.trig

import org.junit.Assert
import org.junit.Test

import static ru.niceone.math.Math.csc
import static ru.niceone.math.tests.Consts.PRECISION

class CscCommonTest {

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
    public void xy_symmetry() {
        Assert.assertEquals(csc(-5), -csc(5), PRECISION);
    }
}
