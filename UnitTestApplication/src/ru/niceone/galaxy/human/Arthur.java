package ru.niceone.galaxy.human;

import ru.niceone.galaxy.environment.Environment;

public class Arthur extends Human {
    Boolean isLying = true;

    public void getUp() {
        this.isLying = false;
        System.out.println("Arthur struggled to his feet.");
    }

    public void hugYourlef() {
        System.out.println("Arthur hugged himself apprehensively.");
    }

    public void lookAround(Environment environment) {
        if (environment.shadows.isLoomingLeaping())
            System.out.println("Hideous alien shapes seemed to throng about him.");

        this.makeBreath(environment.air);
    }

    public Boolean tryToFocus(Environment environment) {
        if (environment.hum.isLowHum()) {
            System.out.println("Low irritating hum kept Arthur's brain from focusing.");
            return false;
        } else {
            return true;
        }
    }
}
