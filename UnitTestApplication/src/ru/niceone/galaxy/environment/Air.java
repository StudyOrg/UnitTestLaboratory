package ru.niceone.galaxy.environment;

public class Air {
    public Smell smell;

    public Air() {
        smell = new Smell();
    }

    public String getStatement() {
        if (this.smell != null) {
            return this.smell.getStatement();
        } else {
            return "Air is clear from the smells.";
        }
    }
}
