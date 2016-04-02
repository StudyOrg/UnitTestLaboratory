package ru.niceone.math.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.niceone.math.Math;

public class MathTests {

    @Test
    public void nan_and_inf() {
        Assert.assertTrue(Double.isNaN(Math.sec(Double.NaN)));
        Assert.assertTrue(Double.isNaN(Math.sec(Double.POSITIVE_INFINITY)));
        Assert.assertTrue(Double.isNaN(Math.sec(Double.NEGATIVE_INFINITY)));
    }

    @Test
    public void values() {
        for (Object[] i : Datasets.set) {
            Assert.assertEquals((Double)i[1], Math.sec((Double)i[0]), 1E-2);
        }
    }
}
