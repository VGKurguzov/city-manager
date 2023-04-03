package com.saxakiil.citymanager.service;

import com.saxakiil.citymanager.repository.ApartmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    public Integer getCountByHouseId(Integer houseId) {
        return apartmentRepository.countApartmentsByHouse_Id(houseId);
    }

}