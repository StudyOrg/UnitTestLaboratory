package ru.niceone.galaxy.human;

import ru.niceone.galaxy.environment.Air;

public class Human {
    Nose nose;
    Lungs lungs;

    public Human() {
        nose = new Nose();
        lungs = new Lungs();
    }

    public void makeBreath(Air air) {
        if (nose.tryIdentifySmell(air) == null) {
            lungs.sidledSmell = air.smell;
        }
    }
}
