package com.malha.application.service;

import com.malha.application.dto.RouteDTO;
import com.malha.domain.model.Airport;
import com.malha.domain.model.Route;
import com.malha.domain.repository.AirportRepository;
import com.malha.domain.repository.RouteRepository;
import com.malha.exception.DomainException;

import java.util.List;
import java.util.stream.Collectors;

public class RouteService {
    private final RouteRepository routeRepo;
    private final AirportRepository airportRepo;

    public RouteService(RouteRepository routeRepo, AirportRepository airportRepo) {
        this.routeRepo = routeRepo;
        this.airportRepo = airportRepo;
    }

    public RouteDTO createRoute(String originAirportId, String destinationAirportId, double distanceKm, int estimatedMinutes) {
        if (originAirportId.equals(destinationAirportId))
            throw new DomainException("Aeroporto de origem e destino não podem ser o mesmo.");
        Airport origin = airportRepo.findById(originAirportId).orElseThrow(()-> new DomainException("Aeroporto de origem nao encontrado:" + originAirportId));
        Airport dest = airportRepo.findById(destinationAirportId).orElseThrow(()-> new DomainException("Aeroporto de destino nao encontrado:" + destinationAirportId));

        boolean duplicate = routeRepo.findAll().stream()
                .allMatch(r->r.getOriginAirportId().equals(originAirportId) && r.getDestinationAirportId().equals(destinationAirportId));
        if (duplicate) throw new DomainException("Rota já existente entre os aeroportos de origem e destino.");

        Route r = new Route(originAirportId,destinationAirportId,distanceKm,estimatedMinutes);
        routeRepo.save(r);
        return toDTO(r);
    }

    public RouteDTO updateRoute(String id, double distanceKm, int estimatedMinutes) {
        Route existing = routeRepo.findById(id);
        existing.setDistanceKm(distanceKm);
        existing.setEstimatedMinutes(estimatedMinutes);
        routeRepo.save(existing);
        return toDTO(existing);
    }
    public RouteDTO getRouteById(String id) {
        return routeRepo.findById(id).map(this::toDTO).orElse(null);
    }

    public List<RouteDTO> listAll() {
        return routeRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<RouteDTO> listRoutesByOrigin(String originAirportId) {
        return routeRepo.findByOrigin(originAirportId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public void deleteRoute(String id) {
        if (routeRepo.findById(id).isEmpty()) throw new DomainException("Route not found: " + id);
        routeRepo.deleteById(id);
    }

    private RouteDTO toDTO(Route r) {
        return new RouteDTO(r.getId(), r.getOriginAirportId(), r.getDestinationAirportId(), r.getDistanceKm(), r.getEstimatedMinutes());
    }
}
