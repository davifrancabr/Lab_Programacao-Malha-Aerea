package com.malha.application.service;

import com.malha.application.dto.AircraftDto;

import java.util.List;

public interface AircraftService {
    AircraftDto createAircraft(String name,String iata, String icao, String registration);
    List<AircraftDto> listAllAircrafts();
}
