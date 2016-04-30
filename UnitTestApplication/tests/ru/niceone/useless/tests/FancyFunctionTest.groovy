package ru.niceone.useless.tests

import org.junit.Assert
import org.junit.Test

import static java.lang.Math.PI
import static ru.niceone.math.tests.Consts.DELTA
import static ru.niceone.math.tests.Consts.PRECISION_SYS
import static ru.niceone.useless.FancyFunction.calc

class FancyFunctionTest {

    @Test
    public void nan() {
        Assert.assertEquals(Double.NaN, calc(Double.NaN), PRECISION_SYS)
    }

    @Test
    public void negative_infinity() {
        Assert.assertEquals(Double.NaN, calc(Double.NEGATIVE_INFINITY), PRECISION_SYS)
    }

    @Test
    public void positive_infinity() {
        Assert.assertEquals(Double.NaN, calc(Double.POSITIVE_INFINITY), PRECISION_SYS)
    }

    @Test
    public void zero_below() {
        Assert.assertEquals(1.00026669642591E2, calc(-DELTA), PRECISION_SYS)
    }

    @Test
    public void zero() {
        Assert.assertEquals(Double.NaN, calc(0), PRECISION_SYS)
    }

    @Test
    public void zero_above() {
        Assert.assertEquals(-3.262355087466043E8, calc(DELTA), PRECISION_SYS)
    }

    @Test
    public void half_pi_below() {
        Assert.assertEquals(-0.00000159157638259162, calc(PI / 2.0 - DELTA), PRECISION_SYS)
    }

    @Test
    public void half_pi() {
        Assert.assertEquals(-0.00000183497632121097, calc(PI / 2.0), PRECISION_SYS)
    }

    @Test
    public void half_pi_above() {
        Assert.assertEquals(-0.00000210900830374477, calc(PI / 2.0 + DELTA), PRECISION_SYS)
    }

    @Test
    public void minus_half_pi_below() {
        Assert.assertEquals(-4.973214239614786E31, calc(-PI / 2.0 - DELTA), PRECISION_SYS)
    }

    @Test
    public void minus_half_pi() {
        Assert.assertEquals(-1.6101094722439263E254, calc(-PI / 2.0), PRECISION_SYS)
    }

    @Test
    public void minus_half_pi_above() {
        Assert.assertEquals(-5.023202989357259E31, calc(-PI / 2.0 + DELTA), PRECISION_SYS)
    }

    @Test
    public void pi_below() {
        Assert.assertEquals(-0.00265436351673463, calc(PI - DELTA), PRECISION_SYS)
    }

    @Test
    public void pi() {
        Assert.assertEquals(-0.00266450292400933, calc(PI), PRECISION_SYS)
    }

    @Test
    public void pi_above() {
        Assert.assertEquals(-0.00267361079468369, calc(PI + DELTA), PRECISION_SYS)
    }

    @Test
    public void minus_pi_below() {
        Assert.assertEquals(100.02666964462566, calc(-PI - DELTA), PRECISION_SYS)
    }

    @Test
    public void minus_pi() {
        Assert.assertEquals(5.819645436199833E15, calc(-PI), PRECISION_SYS)
    }

    @Test
    public void minus_pi_above() {
        Assert.assertEquals(-100.02666964456589, calc(-PI + DELTA), PRECISION_SYS)
    }
}
