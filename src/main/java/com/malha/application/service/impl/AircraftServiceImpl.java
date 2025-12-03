package com.malha.application.service.impl;

import com.malha.application.dto.AirlineDto;
import com.malha.application.service.AirlineService;
import com.malha.domain.repository.AircraftRepository;

import java.util.List;

public class AircraftServiceImpl implements AirlineService {
    private final AircraftRepository aircraftRepository;
    private static int nextId=1;

    public AircraftServiceImpl(AircraftRepository aircraftRepository){
        this.aircraftRepository=aircraftRepository;
    }
    @Override
    public AirlineDto createAirline(String name, String alias, String iata, String icao, String callsign, String country, boolean isActive) {
        return null;
    }

    @Override
    public List<AirlineDto> listAllAirlines() {
        return List.of();
    }
}
