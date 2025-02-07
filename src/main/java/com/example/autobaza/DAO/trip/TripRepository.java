package com.example.autobaza.DAO.trip;

import com.example.autobaza.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TripRepository extends JpaRepository<Trip, Long> {

}
