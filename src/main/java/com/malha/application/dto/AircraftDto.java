package com.malha.application.dto;

import com.malha.domain.model.Airline;

public final class AircraftDto {
    private final int id;
    private final String name;
    private final String iata;
    private final String icao;
    private final String registration;
    private final Airline airline;

    public AircraftDto(int id, String name, String iata, String icao, String registration, Airline airline){
        this.id=id;
        this.name=name;
        this.iata=iata;
        this.icao=icao;
        this.registration=registration;
        this.airline=airline;
    }

    public int getId(){
        return id;
    }


    public String getName(){
        return name;
    }


    public String getIata(){
        return iata;
    }


    public String getIcao(){
        return icao;
    }


    public String getRegistration(){
        return registration;
    }

    public Airline getAirline(){
        return airline;
    }


    @Override
    public String toString(){
        return String.format("Id: %d\nName: %s\nIATA: %s\nICAO: %s\nRegistration: %s\nAirline: %s",
                id, name, iata, icao, registration, airline);
    }
}
