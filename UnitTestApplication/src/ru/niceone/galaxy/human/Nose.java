package ru.niceone.galaxy.human;

import ru.niceone.galaxy.environment.Air;
import ru.niceone.galaxy.environment.Smell;

public class Nose {
    public Smell tryIdentifySmell(Air air) {
        if (!air.smell.isThickAndMusty()) {
            return air.smell;
        } else {
            System.out.println("The air was thick with musty smells which sidled into his lungs without identifying themselves.");
            return null;
        }
    }
}
