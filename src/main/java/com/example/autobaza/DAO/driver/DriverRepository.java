package com.example.autobaza.DAO.driver;

import com.example.autobaza.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Repository
@Transactional
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findDriverById(Long id);

    Driver findDriverByName(String name);

    @Modifying
    @Query("UPDATE Driver d SET d.earnings = :earnings WHERE d.id = :id")
    void updateDriverEarnings(@Param("id") Long id, @Param("earnings") BigDecimal earnings);
}
