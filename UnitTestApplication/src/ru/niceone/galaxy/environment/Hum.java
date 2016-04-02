package ru.niceone.galaxy.environment;

public class Hum {
    Boolean isSounding = true;
    Boolean isLow = true;

    public Boolean isLowHum() {
        return this.isLow && this.isSounding;
    }
}
