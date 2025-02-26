package com.example.autobaza.service.tripservice;

import com.example.autobaza.DAO.trip.TripRepository;
import com.example.autobaza.DTO.TripDTO;
import com.example.autobaza.model.Request;
import com.example.autobaza.model.Trip;
import com.example.autobaza.service.carservice.CarService;
import com.example.autobaza.service.driverservice.DriverService;
import com.example.autobaza.service.requestservice.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class TripServiceImpl implements TripService{
    @Autowired
    CarService carService;

    @Autowired
    DriverService driverService;

    @Autowired
    RequestService requestService;

    @Autowired
    TripRepository tripRepository;

    @Override
    public void createTrip(TripDTO tripDTO) {
        Trip trip = new Trip();

        trip.setCar(carService.findById(tripDTO.getCar_id()));
        trip.setDriver(driverService.findById(tripDTO.getDriver_id()));
        trip.setRequest(requestService.findById(tripDTO.getRequest_id()));
        trip.setEarnings(new BigDecimal(tripDTO.getEarnings()));
        trip.setTripDate(tripDTO.getTripDate());

        Request request = requestService.findById(tripDTO.getRequest_id());

        carService.updateCarCurrentLoad(tripDTO.getCar_id(), request.getCargoAmount());

        tripRepository.save(trip);
    }

    @Override
    public List<Trip> findAll() {
        List<Trip> tripList = tripRepository.findAll();
        return tripList;
    }

    @Override
    public List<Trip> findAllByDriverId(Long id) {
        return tripRepository.findAllByDriver(driverService.findById(id));
    }

    @Override
    public void updateTripByStatus(Long id, String status) {
        tripRepository.updateTripStatus(id, status);
    }

    @Override
    public Trip findById(Long id) {
        return tripRepository.findTripById(id);
    }

    @Override
    public void deleteById(Long id) {
        tripRepository.deleteById(id);
    }
}
