package com.theboatlot.theboatlot;

import java.time.LocalDateTime;

public class Space {
    private Boat boat;
    private boolean booked;
    private java.time.LocalDateTime checkIn;
    private java.time.LocalDateTime checkout;
    private double price;

    public Space(Boat boat, boolean booked, LocalDateTime checkIn, LocalDateTime checkout, double price) {
        this.boat = boat;
        this.booked = booked;
        this.checkIn = checkIn;
        this.checkout = checkout;
        this.price = price;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDateTime checkout) {
        this.checkout = checkout;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}