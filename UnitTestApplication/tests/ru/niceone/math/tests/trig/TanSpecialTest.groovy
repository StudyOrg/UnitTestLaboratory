package ru.niceone.math.tests.trig

import org.junit.Assert
import org.junit.Test

import static ru.niceone.math.Math.tan
import static ru.niceone.math.tests.Consts.PRECISION

class TanSpecialTest {

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
    public void xy_symmetry() {
        Assert.assertEquals(-tan(5), tan(-5), PRECISION)
    }
}
