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
}
