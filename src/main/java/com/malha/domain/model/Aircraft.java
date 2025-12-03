package com.malha.domain.model;

public class Aircraft {
    private int id;
    private String name;
    private String iata;
    private String icao;
    private String registration;

    public Aircraft(int id, String name, String iata, String icao, String registration){
        this.id=id;
        this.name=name;
        this.iata=iata;
        this.icao=icao;
        this.registration=registration;
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

    public String getRegistration(){
        return registration;
    }

    public void setRegistration(String registration){
        this.registration=registration;
    }

    @Override
    public String toString(){
        return String.format("Id: %d\nName: %s\nIATA: %s\nICAO: %s\nRegistration: %s",
                id, name, iata, icao, registration);
    }
}
