package ru.niceone.galaxy.human;

import ru.niceone.galaxy.environment.Air;

public class Human {
    public Nose nose;
    public Lungs lungs;

    public Human() {
        nose = new Nose();
        lungs = new Lungs();
    }

    public void makeBreath(Air air) {
        lungs.sidledSmell = nose.tryIdentifySmell(air);
    }
}
