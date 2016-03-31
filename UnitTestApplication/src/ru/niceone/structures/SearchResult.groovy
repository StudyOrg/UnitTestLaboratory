package ru.niceone.structures

class SearchResult {
    public boolean founded
    public ArrayList<Integer> path

    SearchResult(boolean founded, ArrayList<Integer> path) {
        this.founded = founded
        this.path = path
    }
}
