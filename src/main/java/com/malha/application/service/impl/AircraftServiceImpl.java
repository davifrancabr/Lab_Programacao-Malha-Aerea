package com.malha.application.service.impl;

import com.malha.application.dto.AircraftDto;
import com.malha.application.service.AircraftService;
import com.malha.domain.model.Airline;
import com.malha.domain.repository.AircraftRepository;
import com.malha.exception.BusinessException;

import java.util.List;

public class AircraftServiceImpl implements AircraftService {
    private final AircraftRepository aircraftRepository;
    private static int nextId=1;

    public AircraftServiceImpl(AircraftRepository aircraftRepository){
        this.aircraftRepository=aircraftRepository;
    }


    @Override
    public AircraftDto createAircraft(String name, String iata, String icao, String registration, Airline airline) {
        if (name==null||name.isBlank()) throw new BusinessException("Nome é obrigatório.");
        if (name==null||name.isBlank()) throw new BusinessException("Nome é obrigatório.");
        if (name==null||name.isBlank()) throw new BusinessException("Nome é obrigatório.");
        if (name==null||name.isBlank()) throw new BusinessException("Nome é obrigatório.");
        return null;
    }

    @Override
    public List<AircraftDto> listAllAircrafts() {
        return List.of();
    }
}
