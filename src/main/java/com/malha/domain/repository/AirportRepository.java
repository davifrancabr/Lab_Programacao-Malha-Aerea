package com.malha.domain.repository;

import com.malha.domain.model.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportRepository {
    Airport save(Airport airport);
    Optional<Airport> findById(String id);
    Optional<Airport> findByCode(String code);
    List<Airport> findAll();
    void deleteById(String id);
}
