package com.malha.domain.model;

import java.util.Objects;
import java.util.UUID;

public class Route {
    private final String id;
    private final String originAirportId;
    private final String destinationAirportId;
    private double distanceKm;
    private int estimatedMinutes;

    public Route(String originAirportId, String destinationAirportId, double distanceKm, int estimatedMinutes) {
        this.id= UUID.randomUUID().toString();
        if (originAirportId==null || destinationAirportId==null)
            throw new IllegalArgumentException("Aeroporto de partida e destino precisam ser preenchido.");
        if (originAirportId.equals(destinationAirportId))
            throw new IllegalArgumentException("Aeroporto de partida e destino não podem ser os mesmos.");
        setDistanceKm(distanceKm);
        setEstimatedMinutes(estimatedMinutes);
        this.originAirportId = originAirportId;
        this.destinationAirportId = destinationAirportId;
    }
    public Route(String id, String originAirportId, String destinationAirportId, double distanceKm, int estimatedMinutes) {
        this.id = id;
        this.originAirportId = originAirportId;
        this.destinationAirportId = destinationAirportId;
        setDistanceKm(distanceKm);
        setEstimatedMinutes(estimatedMinutes);
    }

    public String getId() {
        return id;
    }

    public String getOriginAirportId() {
        return originAirportId;
    }

    public String getDestinationAirportId() {
        return destinationAirportId;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        if (distanceKm<=0) throw new IllegalArgumentException("Distancia deve ser maior que zero");
        this.distanceKm = distanceKm;
    }

    public int getEstimatedMinutes() {
        return estimatedMinutes;
    }
    public void setEstimatedMinutes(int estimatedMinutes) {
        if (estimatedMinutes<=0) throw new IllegalArgumentException("Tempo deve ser maior que zero");
        this.estimatedMinutes = estimatedMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id.equals(route.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return String.format("Route[%s] %s -> %s (%.1f km, %d min)",
                id, originAirportId, destinationAirportId, distanceKm, estimatedMinutes);
    }
}
