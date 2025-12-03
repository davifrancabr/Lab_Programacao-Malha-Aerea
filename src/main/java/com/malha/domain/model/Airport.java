package com.malha.domain.model;

import java.util.Objects;
import java.util.UUID;

public class Airport {
    private final String id;
    private String code;
    private String name;
    private String city;
    private String country;

    public Airport(String code, String name, String city, String country){
        this.id= UUID.randomUUID().toString();
        setCode(code);
        setName(name);
        setCity(city);
        setCountry(country);
    }

    public Airport(String id, String code, String name, String city, String country){
        this.id=id;
        setCode(code);
        setName(name);
        setCity(city);
        setCountry(country);
    }

    public String getId(){
        return id;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        if (code==null|| code.trim().isEmpty()) throw new IllegalArgumentException("Código IATA não pode ser nulo.");
        this.code=code.trim().toUpperCase();
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        if (name==null||name.trim().isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio");
        this.name=name.trim();
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city=city == null ? "": city.trim();
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country=country == null ? "": country.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return id.equals(airport.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return String.format("id: %s\nName: %s\nCity: %s\nCountry: %s\nIATA %s", id, name, city, country, code);
    }
}
