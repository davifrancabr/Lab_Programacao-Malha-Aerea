package com.malha.application.dto;

public class RouteDTO {
    public String id;
    public String originAirportId;
    public String destinationAirportId;
    public double distanceKm;
    public int estimatedMinutes;

    public RouteDTO() {}
    public RouteDTO(String id, String originAirportId, String destinationAirportId, double distanceKm, int estimatedMinutes) {
        this.id = id;
        this.originAirportId = originAirportId;
        this.destinationAirportId = destinationAirportId;
        this.distanceKm = distanceKm;
        this.estimatedMinutes = estimatedMinutes;
    }
}
