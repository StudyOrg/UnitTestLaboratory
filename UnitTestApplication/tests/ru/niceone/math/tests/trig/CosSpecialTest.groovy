package ru.niceone.math.tests.trig

import org.junit.Assert
import org.junit.Test

import static java.lang.Math.PI
import static ru.niceone.math.Math.cos
import static ru.niceone.math.tests.Consts.DELTA
import static ru.niceone.math.tests.Consts.PRECISION

class CosSpecialTest {

    /* - 2 PI */

    @Test
    public void near_minus_two_pi_below() {
        Assert.assertEquals(0.99995, cos(-2 * PI - DELTA), PRECISION);
    }

    @Test
    public void minus_two_pi() {
        Assert.assertEquals(1.0, cos(-2 * PI), PRECISION);
    }

    @Test
    public void near_minus_two_pi_above() {
        Assert.assertEquals(0.99995, cos(-2 * PI + DELTA), PRECISION);
    }

    /* - 3/2 PI */

    @Test
    public void near_minus_onehalf_pi_below() {
        Assert.assertEquals(0.0099998, cos(-3 / 2 * PI - DELTA), PRECISION);
    }

    @Test
    public void minus_onehalf_pi() {
        Assert.assertEquals(0.0, cos(-3 / 2 * PI), PRECISION);
    }

    @Test
    public void near_minus_onehalf_pi_above() {
        Assert.assertEquals(-0.0099998, cos(-3 / 2 * PI + DELTA), PRECISION);
    }

    /* - PI */

    @Test
    public void near_minus_pi_below() {
        Assert.assertEquals(-0.99995, cos(-PI - DELTA), PRECISION);
    }

    @Test
    public void minus_pi() {
        Assert.assertEquals(-1.0, cos(-PI), PRECISION);
    }

    @Test
    public void near_minus_pi_above() {
        Assert.assertEquals(-0.99995, cos(-PI + DELTA), PRECISION);
    }

    /* - PI / 2 */

    @Test
    public void near_minus_half_pi_below() {
        Assert.assertEquals(-0.0099998, cos((-PI / 2) - DELTA), PRECISION);
    }

    @Test
    public void minus_half_pi() {
        Assert.assertEquals(0.0, cos(-PI / 2), PRECISION);
    }

    @Test
    public void near_minus_half_pi_above() {
        Assert.assertEquals(0.0099998, cos((-PI / 2) + DELTA), PRECISION);
    }

    /* 0 */

    @Test
    public void near_zero_below() {
        Assert.assertEquals(0.9999500, cos(-DELTA), PRECISION);
    }

    @Test
    public void zero() {
        Assert.assertEquals(1.0, cos(0.0), PRECISION);
    }

    @Test
    public void near_zero_above() {
        Assert.assertEquals(0.9999500, cos(DELTA), PRECISION);
    }

    /* PI / 2 */

    @Test
    public void near_half_pi_below() {
        Assert.assertEquals(0.0099998, cos((PI / 2) - DELTA), PRECISION);
    }

    @Test
    public void half_pi() {
        Assert.assertEquals(0.0, cos(PI / 2), PRECISION);
    }

    @Test
    public void near_half_pi_above() {
        Assert.assertEquals(-0.0099998, cos((PI / 2) + DELTA), PRECISION);
    }

    /* PI */

    @Test
    public void near_pi_below() {
        Assert.assertEquals(-0.99995, cos(PI - DELTA), PRECISION);
    }

    @Test
    public void pi() {
        Assert.assertEquals(-1.0, cos(PI), PRECISION);
    }

    @Test
    public void near_pi_above() {
        Assert.assertEquals(-0.99995, cos(PI + DELTA), PRECISION);
    }

    /* 3/2 PI */

    @Test
    public void near_onehalf_pi_below() {
        Assert.assertEquals(-0.0099998, cos(3 / 2 * PI - DELTA), PRECISION);
    }

    @Test
    public void onehalf_pi() {
        Assert.assertEquals(0.0, cos(3 / 2 * PI), PRECISION);
    }

    @Test
    public void near_onehalf_pi_above() {
        Assert.assertEquals(0.0099998, cos(3 / 2 * PI + DELTA), PRECISION);
    }

    /* 2 PI */

    @Test
    public void near_two_pi_below() {
        Assert.assertEquals(0.99995, cos(2 * PI - DELTA), PRECISION);
    }

    @Test
    public void two_pi() {
        Assert.assertEquals(1.0, cos(2 * PI), PRECISION);
    }

    @Test
    public void near_two_pi_above() {
        Assert.assertEquals(0.99995, cos(2 * PI + DELTA), PRECISION);
    }
}
