package com.example.autobaza.service.driverservice;

import com.example.autobaza.DAO.driver.DriverRepository;
import com.example.autobaza.DTO.DriverDTO;
import com.example.autobaza.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
    DriverRepository driverRepository;

    @Override
    public void createDriver(DriverDTO driverDTO) {
        Driver driver = new Driver();

        driver.setName(driverDTO.getName());
        driver.setExperience(driverDTO.getExperience());

        driverRepository.save(driver);
    }

    @Override
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }
}
