package com.theboatlot.theboatlot;


import java.util.Arrays;

public class Lot {
    private static int NUM_CREATED = 0;
    private int id;
    private Spot[] spots;
    private String lotName;
    private double hourlyPrice;

    public double getHourlyPrice() {
        return hourlyPrice;
    }

    public void setHourlyPrice(double hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Spot[] getSpots() {
        return spots;
    }

    public void setSpots(Spot[] spots) {
        this.spots = spots;
    }

    /**
     * creates a new lot, setting that lot's spaces
     * to a random amount.
     * @return
     */
    public static Lot createLot(String nameTheLot, double hourlyPrice) {
        Lot l = new Lot();
        l.setId(NUM_CREATED++);
        l.setSpots(new Spot[(int)(20)]);

        for (int i = 0; i < l.getSpots().length; i++) {
            l.getSpots()[i] = new Spot();
        }

        l.setLotName(nameTheLot);
        l.setHourlyPrice(hourlyPrice);

        return l;
    }
}
