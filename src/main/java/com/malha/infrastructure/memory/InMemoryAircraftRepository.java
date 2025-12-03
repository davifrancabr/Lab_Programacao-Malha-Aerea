package com.malha.infrastructure.memory;

import com.malha.domain.model.Aircraft;
import com.malha.domain.repository.AircraftRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryAircraftRepository implements AircraftRepository {
    private final Map<String, Aircraft> storage = new ConcurrentHashMap<>();

    @Override
    public Aircraft save(Aircraft aircraft) {
        storage.put(aircraft.getId(), aircraft);
        return aircraft;
    }

    @Override
    public Optional<Aircraft> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Aircraft> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<Aircraft> findByName(String name) {
        if (name == null) return Optional.empty();
        String normalized = name.trim();
        return storage.values().stream()
                .filter(a->a.getName().equalsIgnoreCase(normalized))
                .findFirst();
    }

    @Override
    public void deleteById(String id) {
        storage.remove(id);
    }
}
