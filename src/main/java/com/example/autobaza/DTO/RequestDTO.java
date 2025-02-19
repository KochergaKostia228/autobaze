package com.example.autobaza.DTO;

import javax.persistence.Column;

public class RequestDTO {
    private String destination;

    private int cargoAmount;

    private String cargoType;

    public int getCargoAmount() {
        return cargoAmount;
    }

    public void setCargoAmount(int cargoAmount) {
        this.cargoAmount = cargoAmount;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
