package com.example.autobaza.DAO.car;

import com.example.autobaza.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findCarById(Long id);

    @Modifying
    @Query("UPDATE Car c SET c.currentLoad = :currentLoad WHERE c.id = :id")
    int updateCarCurrentLoad(@Param("id") Long id, @Param("currentLoad") int currentLoad);

    @Modifying
    @Query("UPDATE Car c SET c.broken = :broken WHERE c.id = :id")
    int updateCarBroken(@Param("id") Long id, @Param("broken") boolean broken);
}
