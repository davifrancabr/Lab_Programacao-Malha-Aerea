package com.malha.application.dto;

public final class AirportDto {
    private final int id;
    private final String name;
    private final String city;
    private final String country;
    private final String icao;
    private final String iata;
    private final double latitude;
    private final double longitude;
    private final int altitude;

    public AirportDto(int id, String name, String city, String country, String icao, String iata, double latitude, double longitude, int altitude){
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

    public String getName(){
        return name;
    }

    public String getCity(){
        return city;
    }

    public String getCountry(){
        return country;
    }

    public String getIcao(){
        return icao;
    }


    public String getIata(){
        return iata;
    }


    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public int getAltitude(){
        return altitude;
    }

    @Override
    public String toString(){
        return String.format("id: %d\nName: %s\nCity: %s\nCountry: %s\nICAO: %s\nIATA: %s\nLatitude: %f\nLongitude: %f\nAltitude: %d", id,name,city,country,icao,iata,latitude,longitude,altitude);
    }
}
