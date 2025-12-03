package com.malha.domain.model;

public class Flight {
    private int id;
    private Airport origin;
    private Airport destination;
    private Airport alternative;
    private double flightTime;
    private int altitude;
    private Aircraft aircraft;
    private String route;

    public Flight(int id, Airport origin, Airport destination, Airport alternative, double flightTime, int altitude, Aircraft aircraft, String route){
        this.id=id;
        this.origin=origin;
        this.destination=destination;
        this.alternative=alternative;
        this.flightTime=flightTime;
        this.altitude=altitude;
        this.aircraft=aircraft;
        this.route=route;
    }

    public int getId(){
        return id;
    }

    public Airport getOrigin(){
        return origin;
    }

    public Airport getDestination(){
        return destination;
    }

    public Airport getAlternative(){
        return alternative;
    }

    public double getFlightTime(){
        return flightTime;
    }

    public int getAltitude(){
        return altitude;
    }

    public Aircraft getAircraft(){
        return aircraft;
    }

    public String getRoute(){
        return route;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setOrigin(Airport origin){
        this.origin=origin;
    }

    public void setDestination(Airport destination){
        this.destination=destination;
    }

    public void setAlternative(Airport alternative){
        this.alternative=alternative;
    }

    public void setFlightTime(double flightTime){
        this.flightTime=flightTime;
    }

    public void setAltitude(int altitude){
        this.altitude=altitude;
    }

    public void setAircraft(Aircraft aircraft){
        this.aircraft=aircraft;
    }

    public void setRoute(String route){
        this.route=route;
    }

    @Override
    public String toString(){
        return String.format("Id: %d\nOrigin: %s\nDestination: %s\nAlternative: %s\nFlight Time: %f\nAltitude: %d\nAircraft: %s\nRoute: %s",
                id,origin,destination,alternative,flightTime,altitude,aircraft,route);
    }
}
