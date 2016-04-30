package ru.niceone.math.tests.trig

import org.junit.Assert
import org.junit.Test

import static java.lang.Math.PI
import static ru.niceone.math.Math.cot
import static ru.niceone.math.tests.Consts.DELTA
import static ru.niceone.math.tests.Consts.PRECISION

class CotSpecialTest {

    /* - PI / 2 */

    @Test
    public void near_minus_half_pi_below() {
        Assert.assertEquals(0.0100003, cot((-PI / 2) - DELTA), PRECISION);
    }

    @Test
    public void minus_half_pi() {
        Assert.assertEquals(0.0, cot(-PI / 2), PRECISION);
    }

    @Test
    public void near_minus_half_pi_above() {
        Assert.assertEquals(-0.0100003, cot((-PI / 2) + DELTA), PRECISION);
    }

    /* PI / 2 */

    @Test
    public void near_half_pi_below() {
        Assert.assertEquals(0.0100003, cot((PI / 2) - DELTA), PRECISION);
    }

    @Test
    public void half_pi() {
        Assert.assertEquals(0.0, cot(PI / 2), PRECISION);
    }

    @Test
    public void near_half_pi_above() {
        Assert.assertEquals(-0.0100003, cot((PI / 2) + DELTA), PRECISION);
    }
}
