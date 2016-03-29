package ru.niceone.structures.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.niceone.structures.Graph;

import java.util.Set;

public class BfsTests {
    private static Integer seq0[];
    private static Integer seq1[];
    private static Integer seq2[];
    private static Integer seq3[];
    private static Integer seq4[];
    private static Integer seq5[];
    private static Integer seq6[];
    private static Integer seq7[];

    private static Integer parents0[];
    private static Integer parents1[];
    private static Integer parents2[];
    private static Integer parents3[];
    private static Integer parents4[];
    private static Integer parents5[];
    private static Integer parents6[];
    private static Integer parents7[];

    private static Graph g;

    @BeforeClass
    public static void init() {
        g = new Graph();

        seq0 = new Integer[]{0, 1, 3, 5, 7, 6, 2};
        seq1 = new Integer[]{1};
        seq2 = new Integer[]{2, 1, 6, 7, 5, 3};
        seq3 = new Integer[]{3, 1, 5, 7, 6, 2};
        seq4 = new Integer[]{4, 2, 1, 6, 7, 5, 3};
        seq5 = new Integer[]{5, 3, 1, 7, 6, 2};
        seq6 = new Integer[]{6, 2, 7, 1, 5, 3};
        seq7 = new Integer[]{7, 5, 6, 3, 2, 1};

        parents0 = new Integer[]{null, 0, 6, 0, null, 3, 7, 3};
        parents1 = new Integer[]{null, null, null, null, null, null, null, null};
        parents2 = new Integer[]{null, 2, null, 5, null, 7, 2, 6};
        parents3 = new Integer[]{null, 3, 6, null, null, 3, 7, 3};
        parents4 = new Integer[]{null, 2, 4, 5, null, 7, 2, 6};
        parents5 = new Integer[]{null, 3, 6, 5, null, null, 7, 3};
        parents6 = new Integer[]{null, 2, 6, 5, null, 7, null, 6};
        parents7 = new Integer[]{null, 3, 6, 5, null, 7, 7, null};
    }

    @Test
    public void test_results() {
        Set keys = g.breadthFirstSearch().keySet();

        for (Object key : keys) {
            Assert.assertArrayEquals((key.equals("seq") ? seq0 : parents0), (Integer[]) g.breadthFirstSearch(0).get(key));
            Assert.assertArrayEquals((key.equals("seq") ? seq1 : parents1), (Integer[]) g.breadthFirstSearch(1).get(key));
            Assert.assertArrayEquals((key.equals("seq") ? seq2 : parents2), (Integer[]) g.breadthFirstSearch(2).get(key));
            Assert.assertArrayEquals((key.equals("seq") ? seq3 : parents3), (Integer[]) g.breadthFirstSearch(3).get(key));
            Assert.assertArrayEquals((key.equals("seq") ? seq4 : parents4), (Integer[]) g.breadthFirstSearch(4).get(key));
            Assert.assertArrayEquals((key.equals("seq") ? seq5 : parents5), (Integer[]) g.breadthFirstSearch(5).get(key));
            Assert.assertArrayEquals((key.equals("seq") ? seq6 : parents6), (Integer[]) g.breadthFirstSearch(6).get(key));
            Assert.assertArrayEquals((key.equals("seq") ? seq7 : parents7), (Integer[]) g.breadthFirstSearch(7).get(key));
        }
    }
}
