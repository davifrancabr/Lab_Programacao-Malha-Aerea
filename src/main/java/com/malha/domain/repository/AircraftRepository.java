package com.malha.domain.repository;

import com.malha.domain.model.AircraftType;

import java.util.List;
import java.util.Optional;

public interface AircraftRepository {
    AircraftType save(AircraftType aircraft);
    Optional<AircraftType> findById(String id);
    List<AircraftType> findAll();
    Optional<AircraftType> findByName(String name);
    void deleteById(String id);
}
