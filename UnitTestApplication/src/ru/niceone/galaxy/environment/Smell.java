package ru.niceone.galaxy.environment;

public class Smell {
    Boolean isThick = true;
    Boolean isMusty = true;

    public Boolean isThickAndMusty() {
        return (this.isThick && this.isMusty);
    }
}
