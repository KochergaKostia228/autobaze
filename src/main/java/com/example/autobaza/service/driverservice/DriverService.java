package com.example.autobaza.service.driverservice;

import com.example.autobaza.DTO.DriverDTO;
import com.example.autobaza.model.Driver;

import java.util.List;

public interface DriverService {
    void createDriver(DriverDTO driverDTO);

    List<Driver> findAll();
}
