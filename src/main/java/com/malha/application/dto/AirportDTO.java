package com.malha.application.dto;



public class AirportDTO {
    public String id;
    public String name;
    public String IataCode;
    public String IcaoCode;
    public String city;
    public String country;

    public AirportDTO(){}

    public AirportDTO(String id, String name, String IataCode, String IcaoCode, String city, String country) {
        this.id = id;
        this.name = name;
        this.IataCode = IataCode;
        this.IcaoCode = IcaoCode;
        this.city = city;
        this.country = country;
    }

}
