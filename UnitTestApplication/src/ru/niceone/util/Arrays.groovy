package ru.niceone.util

class Arrays {
    public static <T> List<List<T>> asListTwoDimensional(T[][] array) {
        List<List<T>> resultArray = new ArrayList<ArrayList<T>>()

        for (int i = 0; i < array.size(); i++) {
            def sublist = []

            for (int j = 0; j < array[i].size(); j++) {
                sublist << array[i][j]
            }

            resultArray << sublist
        }

        return resultArray
    }

    public static ArrayList operate(List a, List b, Closure c) {
        def resultList = []
        a.eachWithIndex { def entry, int i ->
            resultList << c(entry, b[i])
        }

        return resultList
    }
}
