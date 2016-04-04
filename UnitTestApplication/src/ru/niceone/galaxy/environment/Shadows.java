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

    public String getStatement() {
        String state = (this.isMonstrous) ? "Monstrous shadows" : "Shadows";

        state += (this.leaping) ? " leaping" : "";

        if (this.leaping && this.looming) {
            state += " and looming";
        } else if (this.looming) {
            state += " looming";
        } else if (!this.leaping) {
            state += " stopped";
        }

        return state + ".";
    }
}
