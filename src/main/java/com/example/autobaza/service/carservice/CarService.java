package com.example.autobaza.service.carservice;

import com.example.autobaza.DTO.CarDTO;
import com.example.autobaza.model.Car;

import java.util.List;

public interface CarService {
    void createCar(CarDTO carDTO);

    List<Car> findAll();

    Car findById(Long id);

    void updateCarCurrentLoad(long id, int currentLoad);

    void updateCarBroken(long id, boolean broken);

}
