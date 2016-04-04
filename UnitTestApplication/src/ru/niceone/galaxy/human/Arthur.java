package ru.niceone.galaxy.human;

import ru.niceone.galaxy.environment.Environment;

public class Arthur extends Human {
    public static final String ACTIVE_STATE =
            "Arthur struggled to his feet and hugged himself apprehensively. Now he can look around and try to focus on situation.";

    public static final String LYING_STATE = "Arthur is lying and can't do anything.";

    public static final String READY_STATE =
            "Arthur struggled to his feet. And now he can hug yourself, look around and try to focus on situation.";

    Boolean isLying = true;
    Boolean isHugged = false;

    public void getUp() {
        this.isLying = false;
        System.out.println("Arthur struggled to his feet.");
    }

    public void hugYourself() {
        this.isHugged = true;
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

    public String getStatement() {
        if (this.isLying) {
            return LYING_STATE;
        } else if (this.isHugged) {
            return ACTIVE_STATE;
        } else {
            return READY_STATE;
        }
    }
}
