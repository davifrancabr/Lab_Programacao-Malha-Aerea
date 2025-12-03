package com.malha.infrastructure.memory;

import com.malha.domain.model.Airport;
import com.malha.domain.repository.AirportRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryAirportRepository implements AirportRepository {
    private final Map<String, Airport> storage = new ConcurrentHashMap<>();

    @Override
    public Airport save(Airport airport) {
        storage.put(airport.getId(), airport);
        return airport;
    }

    @Override
    public Optional<Airport> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Optional<Airport> findByIcao(String icao) {
        return Optional.empty();
    }

    @Override
    public Optional<Airport> findByIata(String iata) {
        return Optional.empty();
    }

    @Override
    public List<Airport> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(String id) {
        storage.remove(id);
    }
}
