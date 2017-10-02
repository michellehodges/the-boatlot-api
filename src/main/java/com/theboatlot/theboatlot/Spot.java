package com.theboatlot.theboatlot;

import java.time.LocalDateTime;

public class Spot {
    private Boat boat;

    public Spot(Boat boat) {
        this.boat = boat;
    }

    public Spot() {
        this.boat =  null;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }
}