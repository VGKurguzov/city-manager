package com.saxakiil.citymanager.dto;

public record ErrorDto(Integer status, String error, String path, String message, String timestamp) {
}