package com.example.autobaza.DAO.driver;

import com.example.autobaza.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
