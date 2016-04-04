package ru.niceone.galaxy.environment;

public class Hum {
    Boolean isSounding;
    Boolean isLow;

    public Hum() {
        isLow =  true;
        isSounding = true;
    }

    public Boolean isLowHum() {
        return this.isLow && this.isSounding;
    }

    public String getStatement() {
        String state = (this.isLow ? "Low h" : "H");
        state += "um is ";

        state += (this.isSounding) ? "sounding." : "not sounding now.";

        return state;
    }
}
