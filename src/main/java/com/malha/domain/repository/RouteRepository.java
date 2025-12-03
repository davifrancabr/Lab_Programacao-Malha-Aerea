package com.malha.domain.repository;

import com.malha.domain.model.Route;

import java.util.List;

public interface RouteRepository {
    Route save(Route route);
    Route findById(String id);
    List<Route> findAll();
    List<Route> findByOrigin(String originAirportId);
    List<Route> findByDestination(String destinationAirportId);
    void deleteById(String id);
}
