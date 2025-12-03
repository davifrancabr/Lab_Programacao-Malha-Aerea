package com.malha.application.service;

import com.malha.application.dto.AirportDTO;
import com.malha.domain.model.Airport;
import com.malha.domain.repository.AirportRepository;
import com.malha.exception.DomainException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public AirportDTO createAirport(String iata, String icao, String name, String city, String country) {
        if (iata!=null && !iata.trim().isEmpty()) {
            if (airportRepository.findByIata(iata).isPresent()) throw new DomainException("Código IATA já existe: " + iata);
        }
        Airport a = new Airport(iata, icao, name, city, country);
        airportRepository.save(a);
        return toDTO(a);
    }

    public AirportDTO updateAirport(String id, String iata, String icao, String name, String city, String country) {
        Airport existing = airportRepository.findById(id).orElseThrow(()-> new DomainException("Aeroporto não encontrado: " + id));
        if (iata!=null && !iata.trim().isEmpty() && !iata.equalsIgnoreCase(existing.getIata())) {
            if (airportRepository.findByIata(iata).isPresent()) throw new DomainException("Código IATA do aeroporto já existe: " + iata);
        }
        existing.setIata(iata);
        existing.setIcao(icao);
        existing.setName(name);
        existing.setCity(city);
        existing.setCountry(country);
        airportRepository.save(existing);
        return toDTO(existing);
    }
    public AirportDTO getAirportById(String id) {
        return airportRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public List<AirportDTO> listAllAirports() {
        return airportRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public void deleteAirport(String id) {
        if (airportRepository.findById(id).isEmpty()) throw new DomainException("Aeroporto não encontrado: " + id);
        airportRepository.deleteById(id);
    }

    private AirportDTO toDTO(Airport a) {
        return new AirportDTO(a.getId(), a.getIata(), a.getIcao(), a.getName(), a.getCity(), a.getCountry());
    }
}