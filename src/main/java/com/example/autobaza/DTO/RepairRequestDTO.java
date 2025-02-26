package com.example.autobaza.DTO;

import javax.persistence.Column;

public class RepairRequestDTO {

    private Long car_id = 0L;

    private String description;

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
