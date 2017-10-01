package com.theboatlot.theboatlot;
import java.time.LocalDateTime;

public class Transaction {
    private Boat boat;
    private LocalDateTime checkedInDate;
    private LocalDateTime checkedOutDate;
    private double price;

    public Transaction(Boat boat, LocalDateTime checkedInDate, LocalDateTime checkedOutDate, double price) {
        this.boat = boat;
        this.checkedInDate = checkedInDate;
        this.checkedOutDate = checkedOutDate;
        this.price = price;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public LocalDateTime getCheckedInDate() {
        return checkedInDate;
    }

    public void setCheckedInDate(LocalDateTime checkedInDate) {
        this.checkedInDate = checkedInDate;
    }

    public LocalDateTime getCheckedOutDate() {
        return checkedOutDate;
    }

    public void setCheckedOutDate(LocalDateTime checkedOutDate) {
        this.checkedOutDate = checkedOutDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}