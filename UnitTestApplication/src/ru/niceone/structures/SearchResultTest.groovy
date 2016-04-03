package ru.niceone.structures

class SearchResultTest extends SearchResult {
    public ArrayList<String> programNodes

    SearchResultTest(boolean founded, ArrayList<Integer> path, ArrayList<String> programNode) {
        super(founded, path)
        this.programNodes = programNode
    }
}
