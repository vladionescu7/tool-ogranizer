package com.toologranizer.dto.cordlessDrill;

import java.util.Objects;

public class CordlessDrillRequest {

    private String brand;

    private String model;

    private Boolean isTaken;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getTaken() {
        return isTaken;
    }

    public void setTaken(Boolean taken) {
        isTaken = taken;
    }
}
