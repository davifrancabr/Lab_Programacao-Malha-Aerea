package com.malha.domain.model;

public class Airport {
    private int id;
    private String name;
    private String city;
    private String country;
    private String icao;
    private String iata;
    private double latitude;
    private double longitude;
    private int altitude;

    public Airport(int id, String name, String city, String country, String icao, String iata, double latitude, double longitude, int altitude){
        this.id=id;
        this.name=name;
        this.city=city;
        this.country=country;
        this.icao=icao;
        this.iata=iata;
        this.latitude=latitude;
        this.longitude=longitude;
        this.altitude=altitude;
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

    public void setName(String name) {
        this.name=name;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city=city;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country=country;
    }

    public String getIcao(){
        return icao;
    }

    public void setIcao(String icao){
        this.icao=icao;
    }

    public String getIata(){
        return iata;
    }

    public void setIata(String iata){
        this.iata=iata;
    }

    public double getLatitude(){
        return latitude;
    }

    public void setLatitude(double latitude){
        this.latitude=latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public void setLongitude(double longitude){
        this.longitude=longitude;
    }

    public int getAltitude(){
        return altitude;
    }

    public void setAltitude(int altitude){
        this.altitude=altitude;
    }

    @Override
    public String toString(){
        return String.format("id: %d\nName: %s\nCity: %s\nCountry: %s\nICAO: %s\nIATA: %s\nLatitude: %f\nLongitude: %f\nAltitude: %d", id,name,city,country,icao,iata,latitude,longitude,altitude);
    }
}
