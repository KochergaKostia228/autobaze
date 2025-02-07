package com.example.autobaza.service.carservice;

import com.example.autobaza.DAO.car.CarRepository;
import com.example.autobaza.DTO.CarDTO;
import com.example.autobaza.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;

    @Override
    public void createCar(CarDTO carDTO) {
        Car car = new Car();

        car.setCapacity(carDTO.getCapacity());

        carRepository.save(car);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }
}
