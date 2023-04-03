package com.saxakiil.citymanager.controller;

import com.saxakiil.citymanager.dto.CityResponse;
import com.saxakiil.citymanager.service.CityService;
import com.saxakiil.citymanager.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;
    private final HouseService houseService;

    @GetMapping("/")
    public ResponseEntity<List<CityResponse>> getAll() {
        final List<CityResponse> cityResponseList = cityService.getAll().stream()
                .map(city -> new CityResponse(city, houseService.getHouseDtosByCityId(city.getId()).size()))
                .toList();

        return ResponseEntity.ok(cityResponseList);
    }

}
