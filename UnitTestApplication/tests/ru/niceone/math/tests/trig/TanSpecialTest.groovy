package ru.niceone.math.tests.trig

import org.junit.Assert
import org.junit.Test

import static java.lang.Math.PI
import static ru.niceone.math.Math.tan
import static ru.niceone.math.tests.Consts.DELTA
import static ru.niceone.math.tests.Consts.PRECISION

class TanSpecialTest {

    /* - 3/2 PI */

    @Test
    public void near_minus_two_pi_below() {
        Assert.assertEquals(-0.0100003, tan(-2 * PI - DELTA), PRECISION);
    }

    @Test
    public void minus_two_pi() {
        Assert.assertEquals(0.0, tan(-2 * PI), PRECISION);
    }

    @Test
    public void near_minus_two_pi_above() {
        Assert.assertEquals(0.0100003, tan(-2 * PI + DELTA), PRECISION);
    }

    /* - PI */

    @Test
    public void near_minus_pi_below() {
        Assert.assertEquals(-0.0100003, tan(-PI - DELTA), PRECISION);
    }

    @Test
    public void minus_pi() {
        Assert.assertEquals(0.0, tan(-PI), PRECISION);
    }

    @Test
    public void near_minus_pi_above() {
        Assert.assertEquals(0.0100003, tan(-PI + DELTA), PRECISION);
    }

    /* 0 */

    @Test
    public void near_zero_below() {
        Assert.assertEquals(-0.0100003, tan(-DELTA), PRECISION);
    }

    @Test
    public void zero() {
        Assert.assertEquals(0.0, tan(0.0), PRECISION);
    }

    @Test
    public void near_zero_above() {
        Assert.assertEquals(0.0100003, tan(DELTA), PRECISION);
    }

    /* PI */

    @Test
    public void near_pi_below() {
        Assert.assertEquals(-0.0100003, tan(PI - DELTA), PRECISION);
    }

    @Test
    public void pi() {
        Assert.assertEquals(0.0, tan(PI), PRECISION);
    }

    @Test
    public void near_pi_above() {
        Assert.assertEquals(0.0100003, tan(PI + DELTA), PRECISION);
    }

    /* 2 PI */

    @Test
    public void near_two_pi_below() {
        Assert.assertEquals(-0.0100003, tan(2 * PI - DELTA), PRECISION);
    }

    @Test
    public void two_pi() {
        Assert.assertEquals(0.0, tan(2 * PI), PRECISION);
    }

    @Test
    public void near_two_pi_above() {
        Assert.assertEquals(0.0100003, tan(2 * PI + DELTA), PRECISION);
    }
}
