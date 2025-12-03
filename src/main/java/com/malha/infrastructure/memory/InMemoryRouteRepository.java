package com.malha.infrastructure.memory;

import com.malha.domain.model.Route;
import com.malha.domain.repository.RouteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryRouteRepository implements RouteRepository {
    private final Map<String, Route> storage = new ConcurrentHashMap<>();

    @Override
    public Route save(Route route) {
        storage.put(route.getId(), route);
        return route;
    }

    @Override
    public Optional<Route> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Route> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public List<Route> findByOrigin(String originAirportId) {
        return storage.values().stream()
                .filter(r->r.getOriginAirportId().equals(originAirportId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Route> findByDestination(String destinationAirportId) {
        return storage.values().stream()
                .filter(r->r.getDestinationAirportId().equals(destinationAirportId))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        storage.remove(id);
    }
}
