package com.example.autobaza.service.driverservice;

import com.example.autobaza.DTO.DriverDTO;
import com.example.autobaza.model.Driver;

import java.math.BigDecimal;
import java.util.List;

public interface DriverService {
    void createDriver(DriverDTO driverDTO);

    List<Driver> findAll();

    Driver findById(Long id);

    Driver findByName(String name);

    void updateEarnings(Long id, BigDecimal earnings);

}
