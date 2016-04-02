package ru.niceone.galaxy.environment;

public class Smell {
    Boolean isThick = true;
    Boolean isMusty = true;

    public Boolean isThickAndMusty() {
        return (this.isThick && this.isMusty);
    }

    public String getStatement() {
        String state = "";

        state += (this.isThick) ? "thick smell" : "";

        if (this.isThick && this.isMusty) {
            state = "thick and musty smell";
        } else if (this.isMusty) {
            state += "musty smell";
        } else if (!this.isThick) {
            state = "no smell";
        }

        return state + ".";
    }
}
