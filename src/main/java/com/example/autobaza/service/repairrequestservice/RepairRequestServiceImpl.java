package com.example.autobaza.service.repairrequestservice;

import com.example.autobaza.DAO.repair_request.RepairRequestRepository;
import com.example.autobaza.DTO.RepairRequestDTO;
import com.example.autobaza.model.RepairRequest;
import com.example.autobaza.service.carservice.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class RepairRequestServiceImpl implements RepairRequestService {
    @Autowired
    CarService carService;

    @Autowired
    RepairRequestRepository repairRequestRepository;

    @Override
    public void createRequest(RepairRequestDTO repairRequestDTO) {
        RepairRequest repairRequest = new RepairRequest();

        // Устанавливаем часовой пояс для Киева
        ZoneId kievZone = ZoneId.of("Europe/Kiev");

        // Получаем текущее время в Киевском часовом поясе
        ZonedDateTime kievTime = ZonedDateTime.now(kievZone);

        LocalDateTime localDateTime = kievTime.toLocalDateTime();

        // Добавляем 1 день
        LocalDateTime newDateTime = localDateTime.plusDays(1);

        repairRequest.setDescription(repairRequestDTO.getDescription());
        repairRequest.setCar(carService.findById(repairRequestDTO.getCar_id()));
        repairRequest.setRequestDate(newDateTime);

        repairRequestRepository.save(repairRequest);
    }

    @Override
    public List<RepairRequest> findAll() {
        return repairRequestRepository.findAll();
    }

    @Override
    public RepairRequest findById(Long id) {
        return repairRequestRepository.findRepairRequestById(id);
    }
}
