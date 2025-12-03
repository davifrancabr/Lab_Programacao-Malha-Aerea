package com.malha.application.dto;



public class AirportDTO {
    public String id;
    public String name;
    public String code;
    public String city;
    public String country;

    public AirportDTO(){}

    public AirportDTO(String id, String code, String name, String city, String country) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.city = city;
        this.country = country;
    }

}
