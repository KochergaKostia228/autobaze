package com.example.autobaza.service.repairrequestservice;

import com.example.autobaza.DTO.RepairRequestDTO;
import com.example.autobaza.DTO.RequestDTO;
import com.example.autobaza.model.RepairRequest;
import com.example.autobaza.model.Request;

import java.util.List;

public interface RepairRequestService {
    void createRequest(RepairRequestDTO repairRequestDTO);

    List<RepairRequest> findAll();

    RepairRequest findById(Long id);
}
