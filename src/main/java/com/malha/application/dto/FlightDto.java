package com.malha.application.dto;

import com.malha.domain.model.Aircraft;
import com.malha.domain.model.Airport;

public final class FlightDto {
    private final int id;
    private final Airport origin;
    private final Airport destination;
    private final Airport alternative;
    private final double flightTime;
    private final int altitude;
    private final Aircraft aircraft;
    private final String route;

    public FlightDto(int id, Airport origin, Airport destination, Airport alternative, double flightTime, int altitude, Aircraft aircraft, String route){
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


    @Override
    public String toString(){
        return String.format("Id: %d\nOrigin: %s\nDestination: %s\nAlternative: %s\nFlight Time: %f\nAltitude: %d\nAircraft: %s\nRoute: %s",
                id,origin,destination,alternative,flightTime,altitude,aircraft,route);
    }
}
