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
    public void positive_dataset() {
        int i = 0;
        for (double x = Datasets.begin; x <= Datasets.end; x += Datasets.step) {
            System.out.print(x + " ");
            Assert.assertEquals(Datasets.set[i], Math.sec(x), 0.1);
        }
    }
}
