package com.malha.domain.model;

public class Airline {
    private int id;
    private String name;
    private String alias;
    private String iata;
    private String icao;
    private String callsign;
    private String country;
    private boolean isActive;

    public Airline(int id, String name, String alias, String iata, String icao, String callsign, String country, boolean isActive){
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

    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getAlias(){
        return alias;
    }

    public void setAlias(String alias){
        this.alias=alias;
    }

    public String getIata(){
        return iata;
    }

    public void setIata(String iata){
        this.iata=iata;
    }

    public String getIcao(){
        return icao;
    }

    public void setIcao(String icao){
        this.icao=icao;
    }

    public String getCallsign(){
        return callsign;
    }

    public void setCallsign(String callsign){
        this.callsign=callsign;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country=country;
    }

    public boolean getActive(){
        return isActive;
    }

    public void setActive(boolean isActive){
        this.isActive=isActive;
    }

    @Override
    public String toString(){
        return String.format("Id: %d\nName: %s\nAlias: %s\nIATA: %s\nICAO: %s\nCallSign: %s\nCountry: %s\nIs Active: %b",
                id,name,alias,iata,icao,callsign,country,isActive);
    }
}
