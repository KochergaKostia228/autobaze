package com.example.autobaza.service.requestservice;

import com.example.autobaza.DTO.DriverDTO;
import com.example.autobaza.DTO.RequestDTO;
import com.example.autobaza.model.Driver;
import com.example.autobaza.model.Request;

import java.util.List;

public interface RequestService {
    void createRequest(RequestDTO requestDTO);

    List<Request> findAll();

    Request findById(Long id);

    void deleteById(Long id);
}
