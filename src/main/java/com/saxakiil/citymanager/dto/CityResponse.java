package com.saxakiil.citymanager.dto;

import com.saxakiil.citymanager.model.City;

public record CityResponse(City city, Integer houseCount) {
}
