package com.malha.application.dto;

public final class AirlineDto {
    private final int id;
    private final String name;
    private final String alias;
    private final String iata;
    private final String icao;
    private final String callsign;
    private final String country;
    private final boolean isActive;

    public AirlineDto(int id, String name, String alias, String iata, String icao, String callsign, String country, boolean isActive){
        this.id=id;
        this.name=name;
        this.alias=alias;
        this.iata=iata;
        this.icao=icao;
        this.callsign=callsign;
        this.country=country;
        this.isActive=isActive;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAlias(){
        return alias;
    }

    public String getIata(){
        return iata;
    }

    public String getIcao(){
        return icao;
    }

    public String getCallsign(){
        return callsign;
    }

    public String getCountry(){
        return country;
    }

    public boolean getActive(){
        return isActive;
    }

    @Override
    public String toString(){
        return String.format("Id: %d\nName: %s\nAlias: %s\nIATA: %s\nICAO: %s\nCallSign: %s\nCountry: %s\nIs Active: %b",
                id,name,alias,iata,icao,callsign,country,isActive);
    }
}
