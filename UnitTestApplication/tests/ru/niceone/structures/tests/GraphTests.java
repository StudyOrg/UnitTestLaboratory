package ru.niceone.structures.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.niceone.structures.MatrixGraph;

public class GraphTests {
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

    private static MatrixGraph g;

    @BeforeClass
    public static void init() {
        g = new MatrixGraph();

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

    }
}
