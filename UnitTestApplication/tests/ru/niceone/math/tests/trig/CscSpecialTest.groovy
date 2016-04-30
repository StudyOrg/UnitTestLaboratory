package ru.niceone.math.tests.trig

import org.junit.Assert
import org.junit.Test

import static java.lang.Math.PI
import static ru.niceone.math.Math.csc
import static ru.niceone.math.tests.Consts.DELTA
import static ru.niceone.math.tests.Consts.PRECISION

class CscSpecialTest {

    /* - 1/2 PI */

    @Test
    public void near_minus_pi_below() {
        Assert.assertEquals(-1.0000500, csc(-PI/2 - DELTA), PRECISION);
    }

    @Test
    public void minus_pi() {
        Assert.assertEquals(-1.0, csc(-PI/2), PRECISION);
    }

    @Test
    public void near_minus_pi_above() {
        Assert.assertEquals(-1.0000500, csc(-PI/2 + DELTA), PRECISION);
    }

    /* 1/2 PI */

    @Test
    public void near_pi_below() {
        Assert.assertEquals(1.0000500, csc(PI/2 - DELTA), PRECISION);
    }

    @Test
    public void pi() {
        Assert.assertEquals(1.0, csc(PI/2), PRECISION);
    }

    @Test
    public void near_pi_above() {
        Assert.assertEquals(1.0000500, csc(PI/2 + DELTA), PRECISION);
    }
}
