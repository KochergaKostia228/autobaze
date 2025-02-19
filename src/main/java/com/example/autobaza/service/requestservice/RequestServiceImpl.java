package com.example.autobaza.service.requestservice;

import com.example.autobaza.DAO.request.RequestRepository;
import com.example.autobaza.DTO.RequestDTO;
import com.example.autobaza.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    RequestRepository requestRepository;

    @Override
    public void createRequest(RequestDTO requestDTO) {
        Request request = new Request();

        request.setDestination(requestDTO.getDestination());
        request.setCargoAmount(requestDTO.getCargoAmount());
        request.setCargoType(requestDTO.getCargoType());

        requestRepository.save(request);
    }

    @Override
    public List<Request> findAll() {
        return requestRepository.findAll();
    }
}
