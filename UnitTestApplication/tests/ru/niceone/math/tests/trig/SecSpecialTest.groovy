package ru.niceone.math.tests.trig

import org.junit.Assert
import org.junit.Test

import static java.lang.Math.PI
import static ru.niceone.math.Math.sec
import static ru.niceone.math.tests.Consts.DELTA
import static ru.niceone.math.tests.Consts.PRECISION

class SecSpecialTest {

    /* - PI */

    @Test
    public void near_minus_pi_below() {
        Assert.assertEquals(-1.0000500, sec(-PI - DELTA), PRECISION);
    }

    @Test
    public void minus_pi() {
        Assert.assertEquals(-1.0, sec(-PI), PRECISION);
    }

    @Test
    public void near_minus_pi_above() {
        Assert.assertEquals(-1.0000500, sec(-PI + DELTA), PRECISION);
    }

    /* 0 */

    @Test
    public void near_zero_below() {
        Assert.assertEquals(1.0000500, sec(-DELTA), PRECISION);
    }

    @Test
    public void zero() {
        Assert.assertEquals(1.0, sec(0.0), PRECISION);
    }

    @Test
    public void near_zero_above() {
        Assert.assertEquals(1.0000500, sec(DELTA), PRECISION);
    }

    /* PI */

    @Test
    public void near_pi_below() {
        Assert.assertEquals(-1.0000500, sec(PI - DELTA), PRECISION);
    }

    @Test
    public void pi() {
        Assert.assertEquals(-1.0, sec(PI), PRECISION);
    }

    @Test
    public void near_pi_above() {
        Assert.assertEquals(-1.0000500, sec(PI + DELTA), PRECISION);
    }
}
