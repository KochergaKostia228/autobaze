package com.example.autobaza.service.tripservice;

import com.example.autobaza.DTO.TripDTO;
import com.example.autobaza.model.Request;
import com.example.autobaza.model.Trip;

import java.util.List;

public interface TripService {
    void createTrip(TripDTO tripDTO);

    List<Trip> findAll();

    List<Trip> findAllByDriverId(Long id);

    void updateTripByStatus(Long id, String status);

    Trip findById(Long id);

    void deleteById(Long id);
}
