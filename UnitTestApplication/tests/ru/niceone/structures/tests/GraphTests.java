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
import java.util.Arrays;

public class GraphTests {

    private static MatrixGraph<String> graph;
    private static SearchResult result;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void init() {
        graph = new MatrixGraph<>();
    }

    @Test
    public void load_data() {
        exception.expect(BadFormatException.class);
        graph.setGraph(Arrays.asList(Datasets.dataset_bad), ru.niceone.util.Arrays.asListTwoDimensional(Datasets.matrix_bad));
    }

    @Test
    public void graph_searching_small() {
        Integer[] expectedPathOne = {0, 1, 2};
        Integer[] expectedPathTwo = {0};

        graph.setGraph(Arrays.asList(Datasets.dataset_small), ru.niceone.util.Arrays.asListTwoDimensional(Datasets.matrix_small));

        result = graph.breadthFirstSearch("Fee");

        Assert.assertTrue(result.founded);
        Assert.assertArrayEquals(result.path.toArray(), expectedPathOne);

        result = graph.breadthFirstSearch("Bee");

        Assert.assertFalse(result.founded);

        result = graph.breadthFirstSearch("Foo");

        Assert.assertTrue(result.founded);
        Assert.assertArrayEquals(result.path.toArray(), expectedPathTwo);
    }

    @Test
    public void graph_searching_big() {
        Integer[] excpectedPathOne = {0, 1, 5, 2, 3, 6};
        graph.setGraph(Arrays.asList(Datasets.dataset_big), ru.niceone.util.Arrays.asListTwoDimensional(Datasets.matrix_big));
        result = graph.breadthFirstSearch("Eta");

        Assert.assertTrue(result.founded);
        Assert.assertArrayEquals(result.path.toArray(), excpectedPathOne);

        result = graph.breadthFirstSearch("Foo");
        Assert.assertFalse(result.founded);
    }

    @Test
    public void load_from_bad_json() throws BadFormatException {
        exception.expect(BadFormatException.class);
        exception.expectMessage("Rows count in matrix doesn't equal to values count");
        graph.loadFromJson(new File("../Datasets/bad_data_long_row.json"));

        exception.expectMessage("Cols count in matrix doesn't equal to values count");
        graph.loadFromJson(new File("../Datasets/bad_data_too_much_values.json"));

        exception.expectMessage("'values' field missed or doesn't contains values list");
        graph.loadFromJson(new File("../Datasets/bad_data_bad_json.json"));

        exception.expectMessage("'matrix' field missed or doesn't contains 2d matrix");
        graph.loadFromJson(new File("../Datasets/bad_data_no_matrix.json"));
    }

    @Test
    public void load_from_good_json() {
        graph.loadFromJson(new File("../Datasets/data.json"));
        // Test case one - search in the middle of graph
        Integer[] expectedPathOne = {0, 1, 4, 2, 3, 5};
        result = graph.breadthFirstSearch("F");

        Assert.assertTrue(result.founded);
        Assert.assertArrayEquals(result.path.toArray(), expectedPathOne);

        // Test case two - search in the end of graph
        Integer[] expectedPathTwo = {0, 1, 4, 2, 3, 5, 6, 11, 12, 9, 10, 7, 8};
        result = graph.breadthFirstSearch("I");

        Assert.assertTrue(result.founded);
        Assert.assertArrayEquals(result.path.toArray(), expectedPathTwo);
    }
}
