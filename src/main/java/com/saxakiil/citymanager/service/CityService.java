package com.saxakiil.citymanager.service;

import com.saxakiil.citymanager.exception.RecordNotExistException;
import com.saxakiil.citymanager.model.City;
import com.saxakiil.citymanager.repository.CityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CityService {

    private final CityRepository cityRepository;

    public List<City> getAll() {
        return cityRepository.findAll().stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), result -> {
            if (result.isEmpty()) throw new RecordNotExistException("Cities not exist");
            return result;
        }));
    }
}
