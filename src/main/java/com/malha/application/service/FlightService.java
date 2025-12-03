package com.malha.application.service;

import com.malha.application.dto.FlightDto;
import com.malha.domain.model.Aircraft;
import com.malha.domain.model.Airport;

import java.util.List;

public interface FlightService {
    FlightDto createFlight(Airport origin, Airport destination, Airport alternative, double flightTime, int altitude, Aircraft aircraft, String route);
    List<FlightDto> listAllRoutes();
}

/*
* private final int id;
    private final Airport origin;
    private final Airport destination;
    private final Airport alternative;
    private final double flightTime;
    private final int altitude;
    private final Aircraft aircraft;
    private final String route;
* */