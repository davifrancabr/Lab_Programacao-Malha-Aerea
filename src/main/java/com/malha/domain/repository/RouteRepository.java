package com.malha.domain.repository;

import com.malha.domain.model.Route;

import java.util.List;
import java.util.Optional;

public interface RouteRepository {
    Route save(Route route); // create or update
    Optional<Route> findById(String id);
    List<Route> findAll();
    List<Route> findByOrigin(String originAirportId);
    List<Route> findByDestination(String destinationAirportId);
    void deleteById(String id);
}