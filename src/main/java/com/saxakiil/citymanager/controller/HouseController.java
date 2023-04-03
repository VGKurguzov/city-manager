package com.saxakiil.citymanager.controller;

import com.saxakiil.citymanager.dto.HouseResponse;
import com.saxakiil.citymanager.service.ApartmentService;
import com.saxakiil.citymanager.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/houses")
public class HouseController {

    private final HouseService houseService;
    private final ApartmentService apartmentService;

    @GetMapping(value = "/", params = "city_id")
    public ResponseEntity<List<HouseResponse>> getHousesByCityId(@RequestParam("city_id") Integer cityId) {
        final List<HouseResponse> houseResponseList = houseService.getHouseDtosByCityId(cityId).stream()
                .map(house -> new HouseResponse(house, apartmentService.getCountByHouseId(house.houseId())))
                .toList();
        return ResponseEntity.ok(houseResponseList);
    }

    @GetMapping(value = "/", params = "street_id")
    public ResponseEntity<List<HouseResponse>> getHousesByStreetId(@RequestParam("street_id") Integer streetId) {
        final List<HouseResponse> houseResponseList = houseService.getHouseDtosByStreetId(streetId).stream()
                .map(house -> new HouseResponse(house, apartmentService.getCountByHouseId(house.houseId())))
                .toList();
        return ResponseEntity.ok(houseResponseList);
    }
}
