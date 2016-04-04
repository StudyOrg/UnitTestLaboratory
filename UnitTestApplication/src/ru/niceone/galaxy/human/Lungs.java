package ru.niceone.galaxy.human;

import ru.niceone.galaxy.environment.Smell;

public class Lungs {
    Smell sidledSmell = null;

    public String getStatement() {
        if (this.sidledSmell == null) {
            return "There is no smell.";
        } else {
            return "There is " + sidledSmell.getStatement();
        }
    }
}
