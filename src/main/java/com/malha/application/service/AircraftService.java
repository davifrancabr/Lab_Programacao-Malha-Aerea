package com.malha.application.service;

import com.malha.application.dto.AircraftDto;
import com.malha.domain.model.Airline;

import java.util.List;

public interface AircraftService {
    AircraftDto createAircraft(String name, String iata, String icao, String registration, Airline airline);
    List<AircraftDto> listAllAircrafts();
}
