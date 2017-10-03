package com.theboatlot.theboatlot;
import java.time.LocalDateTime;

public class Transaction {
    private Boat boat;
    private LocalDateTime checkedInDate;
    private LocalDateTime checkedOutDate;
    private double totalCost;


    public Transaction(Boat boat, LocalDateTime checkedInDate, double totalCost) {
        this.boat = boat;
        this.checkedInDate = checkedInDate;
        this.totalCost = totalCost;
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

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public static Transaction createTransaction(Boat boat, LocalDateTime checkedInDate, double totalCost) {
        Transaction t = new Transaction(boat, checkedInDate, totalCost);

        return t;
    }
}