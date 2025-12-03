package com.malha.domain.repository;

import com.malha.domain.model.Aircraft;

import java.util.List;
import java.util.Optional;

public interface AircraftRepository {
    Aircraft save(Aircraft aircraft);
    Optional<Aircraft> findById(int id);
    List<Aircraft> findAll();
    void deleteById(int id);
}
