package ru.niceone.galaxy.environment.things;

public class Match {
    public Boolean isGlow = false;

    public Boolean struckMatch() {
        if (!this.isGlow) {
            System.out.println(" struck another match.");

            this.isGlow = true;
        }

        return true;
    }
}
