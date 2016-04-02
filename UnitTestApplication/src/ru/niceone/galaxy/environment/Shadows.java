package ru.niceone.galaxy.environment;

public class Shadows {
    Boolean leaping = false;
    Boolean looming = false;
    Boolean isMonstrous = true;

    public void toLeap() {
        this.leaping = true;
        System.out.print("Monstrous shadows leaped");
    }

    public void toLoom() {
        this.looming = true;
        System.out.println(" and loomed again.");
    }

    public Boolean isLoomingLeaping() {
        return this.looming && this.leaping && this.isMonstrous;
    }
}
