package com.saxakiil.citymanager.service;

import com.saxakiil.citymanager.dto.HouseDto;
import com.saxakiil.citymanager.exception.RecordNotExistException;
import com.saxakiil.citymanager.repository.HouseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.saxakiil.citymanager.util.Util.HOUSES_WITH_CITY_ID_NOT_EXIST;
import static com.saxakiil.citymanager.util.Util.HOUSES_WITH_STREET_ID_NOT_EXIST;

@Service
@RequiredArgsConstructor
@Transactional
public class HouseService {

    private final HouseRepository houseRepository;

    public List<HouseDto> getHouseDtosByCityId(Integer cityId) {
        return houseRepository.getHouseDtosByCityId(cityId).stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), result -> {
                    if (result.isEmpty()) throw new RecordNotExistException(String
                            .format(HOUSES_WITH_CITY_ID_NOT_EXIST, cityId));
                    return result;
                }));
    }

    public List<HouseDto> getHouseDtosByStreetId(Integer streetId) {
        return houseRepository.getHouseDtosByStreetId(streetId).stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), result -> {
                    if (result.isEmpty()) throw new RecordNotExistException(String
                            .format(HOUSES_WITH_STREET_ID_NOT_EXIST, streetId));
                    return result;
                }));
    }
}
