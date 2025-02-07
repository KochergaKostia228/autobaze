package com.example.autobaza.DTO;

import javax.persistence.Column;

public class DriverDTO {
    private String name;

    private int experience;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
