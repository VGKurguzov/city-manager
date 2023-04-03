package com.saxakiil.citymanager.dto;

import com.saxakiil.citymanager.model.Street;

public record StreetResponse(Street street, Integer houseCount) {
}
