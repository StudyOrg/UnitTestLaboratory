package ru.niceone.structures.tests;

class Datasets {
    public static final String[] dataset_small = {"Foo", "Bar", "Fee"};
    public static final Boolean[][] matrix_small = {
            {false, true, true},
            {true, false, false},
            {true, false, false}
    };

    public static final String[] dataset_big = {"Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota"};
    public static final Boolean[][] matrix_big = {
            {false, true, false, false, false, true, false, false, false},
            {true, false, true, true, false, false, false, false, false},
            {false, true, false, false, false, false, false, false, false},
            {false, true, false, false, true, false, false, false, false},
            {false, false, false, true, false, false, false, false, false},
            {true, false, false, false, false, false, true, false, false},
            {false, false, false, false, false, true, false, true, true},
            {false, false, false, false, false, false, true, false, false},
            {false, false, false, false, false, false, true, false, false}

    };

    public static final String[] dataset_bad = {"A", "B"};
    public static final Boolean[][] matrix_bad = {
            {false, true, true},
            {false, true, false}
    };
}