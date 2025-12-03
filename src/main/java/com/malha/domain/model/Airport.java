package com.malha.domain.model;

import java.util.Objects;
import java.util.UUID;

public class Airport {
    private final String id;
    private IATACode iata;
    private ICAOCode icao;
    private String name;
    private String city;
    private String country;

    public Airport(String name, String city, String country, String icao, String iata){
        this.id= UUID.randomUUID().toString();
        setCity(city);
        setCountry(country);
        setIcao(icao);
        setIata(iata);
        setName(name);
    }

    public Airport(String id, String name, String city, String country, String icao, String iata){
        this.id=id;
        setCity(city);
        setCountry(country);
        setIcao(icao);
        setIata(iata);
        setName(name);
    }

    public String getId(){
        return id;
    }

    public String getIcao(){
        return icao == null ? null : icao.getCode();
    }

    public void setIcao(String icao){
        if (icao == null || icao.trim().isEmpty()) this.icao = null;
        else this.icao = new ICAOCode(icao);
    }

    public String getIata(){
        return iata == null ? null : iata.getCode();
    }

    public void setIata(String iata){
        if (iata == null || iata.trim().isEmpty()) this.iata = null;
        else this.iata = new IATACode(iata);
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
        return String.format("id: %d\nName: %s\nCity: %s\nCountry: %s\nICAO: %s\nIATA: %s", id,name,city,country,icao,iata);
    }
}
