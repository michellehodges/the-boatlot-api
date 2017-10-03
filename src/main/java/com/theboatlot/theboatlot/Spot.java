package com.theboatlot.theboatlot;

import java.time.LocalDateTime;

public class Spot {
    private Transaction transaction;

    public Spot(Transaction transaction) {
        this.transaction = transaction;
    }

    public Spot() {

    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}