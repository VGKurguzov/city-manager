package com.saxakiil.citymanager.service;

import com.saxakiil.citymanager.exception.RecordNotExistException;
import com.saxakiil.citymanager.model.Street;
import com.saxakiil.citymanager.repository.StreetRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.saxakiil.citymanager.util.Util.STREETS_WITH_CITY_ID_NOT_EXIST;

@Service
@RequiredArgsConstructor
@Transactional
public class StreetService {

    private final StreetRepository streetRepository;

    public List<Street> getStreetsByCityId(Integer cityId) {
        return streetRepository.getStreetsByCity_Id(cityId).stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), result -> {
                    if (result.isEmpty()) throw new RecordNotExistException(String
                            .format(STREETS_WITH_CITY_ID_NOT_EXIST, cityId));
                    return result;
                }));
    }


}
