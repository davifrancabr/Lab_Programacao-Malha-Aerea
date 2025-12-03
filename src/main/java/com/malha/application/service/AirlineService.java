package com.malha.application.service;

import com.malha.application.dto.AirlineDto;

import java.util.List;

public interface AirlineService {
    AirlineDto createAirline(String name, String alias, String iata, String icao, String callsign, String country, boolean isActive);
    List<AirlineDto> listAllAirlines();
}

/*
* private final int id;
    private final String name;
    private final String alias;
    private final String iata;
    private final String icao;
    private final String callsign;
    private final String country;
    private final boolean isActive;
* */