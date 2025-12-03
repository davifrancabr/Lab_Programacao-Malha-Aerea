package com.malha.application.service;

import com.malha.application.dto.AirportDTO;
import com.malha.domain.model.Airport;
import com.malha.domain.repository.AirportRepository;
import com.malha.exception.DomainException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AirportService {
    private final AirportRepository repo;

    public AirportService(AirportRepository repo) {
        this.repo = repo;
    }

    public AirportDTO createAirport(String code, String name, String city, String country) {
        Optional.ofNullable(code).ifPresent(c->{
            if (repo.findByCode(c).isPresent()) throw new DomainException("Código IATA já existe: " + code);
        });
        Airport a = new Airport(code, name, city, country);
        repo.save(a);
        return toDTO(a);
    }

    public AirportDTO updateAirport(String id, String code, String name, String city, String country) {
        Airport existing = repo.findById(id).orElseThrow(()-> new DomainException("Aeroporto não encontrado: " + id));
        if (!existing.getCode().equalsIgnoreCase(code)) {
            if (repo.findByCode(code).isPresent()) throw new DomainException("Código IATA do aeroporto já existe: " + code);
        }
        existing.setCode(code);
        existing.setName(name);
        existing.setCity(city);
        existing.setCountry(country);
        repo.save(existing);
        return toDTO(existing);
    }
    public AirportDTO getAirportById(String id) {
        return repo.findById(id).map(this::toDTO).orElse(null);
    }

    public List<AirportDTO> listAllAirports() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public void deleteAirport(String id) {
        if (repo.findById(id).isEmpty()) throw new DomainException("Aeroporto não encontrado: " + id);
        repo.deleteById(id);
    }

    private AirportDTO toDTO(Airport a) {
        return new AirportDTO(a.getId(), a.getCode(), a.getName(), a.getCity(), a.getCountry());
    }
}