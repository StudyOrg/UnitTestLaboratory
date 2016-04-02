package ru.niceone.galaxy.environment;

public class Environment {
    public Shadows shadows;
    public Air air;
    public Hum hum;

    public Environment() {
        shadows = new Shadows();
        air = new Air();
        hum = new Hum();
    }
}
