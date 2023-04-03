package com.saxakiil.citymanager.controller;

import com.saxakiil.citymanager.dto.StreetResponse;
import com.saxakiil.citymanager.service.HouseService;
import com.saxakiil.citymanager.service.StreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/streets")
public class StreetController {

    private final StreetService streetService;
    private final HouseService houseService;

    @GetMapping("/")
    public ResponseEntity<List<StreetResponse>> getStreetsByCityId(@RequestParam("city_id") Integer cityId) {
        final List<StreetResponse> streetResponseList = streetService.getStreetsByCityId(cityId).stream()
                .map(street -> new StreetResponse(street, houseService.getHouseDtosByStreetId(street.getId()).size()))
                .toList();
        return ResponseEntity.ok(streetResponseList);
    }
}
