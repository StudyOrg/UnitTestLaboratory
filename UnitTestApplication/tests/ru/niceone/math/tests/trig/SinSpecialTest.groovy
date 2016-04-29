package ru.niceone.math.tests.trig

import org.junit.Assert
import org.junit.Test

import static java.lang.Math.PI
import static ru.niceone.math.Math.sin
import static ru.niceone.math.tests.Consts.DELTA
import static ru.niceone.math.tests.Consts.PRECISION

class SinSpecialTest {

    /* - 2 PI */

    @Test
    public void near_minus_two_pi_below() {
        Assert.assertEquals(-0.0099998, sin(-2 * PI - DELTA), PRECISION);
    }

    @Test
    public void minus_two_pi() {
        Assert.assertEquals(0.0, sin(-2 * PI), PRECISION);
    }

    @Test
    public void near_minus_two_pi_above() {
        Assert.assertEquals(0.0099998, sin(-2 * PI + DELTA), PRECISION);
    }

    /* - 3/2 PI */

    @Test
    public void near_minus_onehalf_pi_below() {
        Assert.assertEquals(0.99995, sin(-3 / 2 * PI - DELTA), PRECISION);
    }

    @Test
    public void minus_onehalf_pi() {
        Assert.assertEquals(1.0, sin(-3 / 2 * PI), PRECISION);
    }

    @Test
    public void near_minus_onehalf_pi_above() {
        Assert.assertEquals(0.99995, sin(-3 / 2 * PI + DELTA), PRECISION);
    }

    /* - PI */

    @Test
    public void near_minus_pi_below() {
        Assert.assertEquals(0.0099998, sin(-PI - DELTA), PRECISION);
    }

    @Test
    public void minus_pi() {
        Assert.assertEquals(0.0, sin(-PI), PRECISION);
    }

    @Test
    public void near_minus_pi_above() {
        Assert.assertEquals(-0.0099998, sin(-PI + DELTA), PRECISION);
    }

    /* - PI / 2 */

    @Test
    public void near_minus_half_pi_below() {
        Assert.assertEquals(-0.99995, sin((-PI / 2) - DELTA), PRECISION);
    }

    @Test
    public void minus_half_pi() {
        Assert.assertEquals(-1.0, sin(-PI / 2), PRECISION);
    }

    @Test
    public void near_minus_half_pi_above() {
        Assert.assertEquals(-0.99995, sin((-PI / 2) + DELTA), PRECISION);
    }

    /* 0 */

    @Test
    public void near_zero_below() {
        Assert.assertEquals(-0.009999833334166664682542438269099, sin(-DELTA), PRECISION);
    }

    @Test
    public void zero() {
        Assert.assertEquals(0.0, sin(0.0), PRECISION);
    }

    @Test
    public void near_zero_above() {
        Assert.assertEquals(0.009999833334166664682542438269099, sin(DELTA), PRECISION);
    }

    /* PI / 2 */

    @Test
    public void near_half_pi_below() {
        Assert.assertEquals(0.99995, sin((PI / 2) - DELTA), PRECISION);
    }

    @Test
    public void half_pi() {
        Assert.assertEquals(1.0, sin(PI / 2), PRECISION);
    }

    @Test
    public void near_half_pi_above() {
        Assert.assertEquals(0.99995, sin((PI / 2) + DELTA), PRECISION);
    }

    /* PI */

    @Test
    public void near_pi_below() {
        Assert.assertEquals(0.0099998, sin(PI - DELTA), PRECISION);
    }

    @Test
    public void pi() {
        Assert.assertEquals(0.0, sin(PI), PRECISION);
    }

    @Test
    public void near_pi_above() {
        Assert.assertEquals(-0.0099998, sin(PI + DELTA), PRECISION);
    }

    /* 3/2 PI */

    @Test
    public void near_onehalf_pi_below() {
        Assert.assertEquals(-0.99995, sin(3 / 2 * PI - DELTA), PRECISION);
    }

    @Test
    public void onehalf_pi() {
        Assert.assertEquals(-1.0, sin(3 / 2 * PI), PRECISION);
    }

    @Test
    public void near_onehalf_pi_above() {
        Assert.assertEquals(-0.99995, sin(3 / 2 * PI + DELTA), PRECISION);
    }

    /* 2 PI */

    @Test
    public void near_two_pi_below() {
        Assert.assertEquals(-0.0099998, sin(2 * PI - DELTA), PRECISION);
    }

    @Test
    public void two_pi() {
        Assert.assertEquals(0.0, sin(2 * PI), PRECISION);
    }

    @Test
    public void near_two_pi_above() {
        Assert.assertEquals(0.0099998, sin(2 * PI + DELTA), PRECISION);
    }
}
