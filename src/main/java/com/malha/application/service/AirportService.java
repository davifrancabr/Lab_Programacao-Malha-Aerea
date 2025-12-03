package com.malha.application.service;

import com.malha.application.dto.AirportDto;

import java.util.List;

public interface AirportService {
    AirportDto createAirport(String name, String city, String country, String icao, String iata, double latitude, double longitude, int altitude);
    List<AirportDto> listAllAirports();
}
