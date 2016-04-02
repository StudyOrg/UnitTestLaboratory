package ru.niceone.galaxy.human;

import ru.niceone.galaxy.environment.Environment;
import ru.niceone.galaxy.environment.things.Match;

public class Ford {
    Match match;

    public Ford() {
        match = new Match();
    }

    public void findSwitch(Environment environment) {
        System.out.print("Ford");
        if (this.match.struckMatch()) {
            System.out.println("Now I'm starting to find light switcher.");

            environment.shadows.toLeap();
            environment.shadows.toLoom();
        }
    }

    public String getStatement() {
        String state;

        if (this.match != null) {
            state = "Ford has match. ";
            state += this.match.getStatement();
        } else {
            state = "Ford has no things.";
        }

        return state;
    }
}
