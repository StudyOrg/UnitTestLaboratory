package ru.niceone.structures.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.niceone.structures.BadFormatException;
import ru.niceone.structures.MatrixGraph;
import ru.niceone.structures.SearchResult;

import java.io.File;

public class GraphTests {

    private static MatrixGraph<String> g;

    @BeforeClass
    public static void init() {
        g = new MatrixGraph<>();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void test_load_from_bad_json() throws BadFormatException {
        exception.expect(BadFormatException.class);
        exception.expectMessage("Rows count in matrix doesn't equal to values count");
        g.loadFromJson(new File("../Datasets/bad_data_long_row.json"));

        exception.expectMessage("Cols count in matrix doesn't equal to values count");
        g.loadFromJson(new File("../Datasets/bad_data_too_much_values.json"));

        exception.expectMessage("'values' field missed or doesn't contains values list");
        g.loadFromJson(new File("../Datasets/bad_data_bad_json.json"));

        exception.expectMessage("'matrix' field missed or doesn't contains 2d matrix");
        g.loadFromJson(new File("../Datasets/bad_data_no_matrix.json"));
    }

    @Test
    public void test_load_from_good_json() {
        g.loadFromJson(new File("../Datasets/data.json"));
        // Test case one - search in the middle of graph
        SearchResult resultOne = g.breadthFirstSearch("I");
        Integer[] expectedPathOne = {0, 1, 2, 5, 3, 4, 6, 8};

        Assert.assertTrue(resultOne.founded);
        Assert.assertArrayEquals(resultOne.path.toArray(), expectedPathOne);

        // Test case two - search in the end of graph
        SearchResult resultTwo = g.breadthFirstSearch("I");
        Integer[] expectedPathTwo = {0, 1, 2, 5, 3, 4, 6, 8};

        Assert.assertTrue(resultTwo.founded);
        Assert.assertArrayEquals(resultTwo.path.toArray(), expectedPathTwo);
    }
}
