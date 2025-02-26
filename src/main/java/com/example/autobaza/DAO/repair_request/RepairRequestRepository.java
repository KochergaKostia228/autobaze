package com.example.autobaza.DAO.repair_request;

import com.example.autobaza.model.RepairRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RepairRequestRepository extends JpaRepository<RepairRequest, Long> {
    RepairRequest findRepairRequestById(Long id);
}
