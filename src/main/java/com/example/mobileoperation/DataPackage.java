package com.example.mobileoperation;

import java.time.LocalDate;

public class DataPackage {
    private String packageName;
    private float dataAmount;
    private String validity;
    private String availability;
    private LocalDate offerEnds;
    private float price;


    public String getPackageName() {
        return packageName;
    }

    public float getPrice() {
        return price;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDataAmount(float dataAmount) {
        this.dataAmount = dataAmount;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setOfferEnds(LocalDate offerEnds) {
        this.offerEnds = offerEnds;
    }

    public float getDataAmount() {
        return dataAmount;
    }

    public String getValidity() {
        return validity;
    }

    public String getAvailability() {
        return availability;
    }

    public LocalDate getOfferEnds() {
        return offerEnds;
    }

    public DataPackage() {
        this.packageName = null;
        this.dataAmount = 0;
        this.validity = null;
        this.availability = null;
        this.offerEnds = null;
        this.price = 0;
    }

    @Override
    public String toString() {
        return "DataPackage{" +
                "packageName='" + packageName + '\'' +
                ", dataAmount=" + dataAmount +
                ", validity=" + validity +
                ", availability='" + availability + '\'' +
                ", offerEnds=" + offerEnds +
                '}';
    }

    public DataPackage(String packageName, float dataAmount, String validity, String availability, LocalDate offerEnds, float price) {
        this.packageName = packageName;
        this.dataAmount = dataAmount;
        this.validity = validity;
        this.availability = availability;
        this.offerEnds = offerEnds;
        this.price = price;
    }
}
