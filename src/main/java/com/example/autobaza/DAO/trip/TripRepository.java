package com.example.autobaza.DAO.trip;

import com.example.autobaza.model.Driver;
import com.example.autobaza.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findAllByDriver(Driver driver);

    Trip findTripById(Long id);

    @Modifying
    @Query("UPDATE Trip t SET t.status = :status WHERE t.id = :id")
    void updateTripStatus(@Param("id") Long id, @Param("status") String status);
}
