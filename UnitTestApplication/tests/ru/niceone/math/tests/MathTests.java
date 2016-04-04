package ru.niceone.math.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.niceone.math.Math;

public class MathTests {

    @Test
    public void nan() {
        Assert.assertTrue(Double.isNaN(Math.sec(Double.NaN)));
    }

    @Test
    public void neg_inf() {
        Assert.assertTrue(Double.isNaN(Math.sec(Double.NEGATIVE_INFINITY)));
    }

    @Test
    public void pos_inf() {
        Assert.assertTrue(Double.isNaN(Math.sec(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void values() {
        for (Object[] i : Datasets.set) {
            Assert.assertEquals((Double)i[1], Math.sec((Double)i[0]), 1E-2);
        }
    }
}
