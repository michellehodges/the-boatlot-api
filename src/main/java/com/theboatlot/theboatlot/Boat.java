package com.theboatlot.theboatlot;

public class Boat {
    private String licenseNumber;

    public Boat(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Boat() {

    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public static Boat createBoat(String enterLicense) {
        Boat b = new Boat(enterLicense);

        return b;
    }
}
