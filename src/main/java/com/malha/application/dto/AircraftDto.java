package com.malha.application.dto;

public final class AircraftDto {
    private final int id;
    private final String name;
    private final String iata;
    private final String icao;
    private final String registration;

    public AircraftDto(int id, String name, String iata, String icao, String registration){
        this.id=id;
        this.name=name;
        this.iata=iata;
        this.icao=icao;
        this.registration=registration;
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


    @Override
    public String toString(){
        return String.format("Id: %d\nName: %s\nIATA: %s\nICAO: %s\nRegistration: %s",
                id, name, iata, icao, registration);
    }
}
