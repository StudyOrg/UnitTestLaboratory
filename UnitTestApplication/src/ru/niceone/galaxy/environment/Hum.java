package ru.niceone.galaxy.environment;

public class Hum {
    Boolean isSounding = true;
    Boolean isLow = true;

    public Boolean isLowHum() {
        return this.isLow && this.isSounding;
    }

    public String getStatement() {
        String state = "Hum is ";

        state += (this.isSounding) ? "sounding" : "not sounding now.";

        if (this.isSounding && this.isLow) {
            state += " and low.";
        }

        return state;
    }
}
