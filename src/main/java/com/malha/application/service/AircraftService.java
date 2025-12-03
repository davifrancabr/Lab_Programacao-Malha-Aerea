package com.malha.application.service;

import com.malha.application.dto.AircraftDTO;
import com.malha.domain.model.Aircraft;
import com.malha.domain.repository.AircraftRepository;
import com.malha.exception.DomainException;

import java.util.List;
import java.util.stream.Collectors;

public class AircraftService {
    private final AircraftRepository repo;

    public AircraftService(AircraftRepository repo){
        this.repo=repo;
    }

    public AircraftDTO create(String name){
        if (repo.findByName(name).isPresent()) throw new DomainException("Aeronave já existe: " + name);
        Aircraft at = new Aircraft(name);
        repo.save(at);
        return toDTO(at);
    }

    public AircraftDTO update(String id, String name){
        Aircraft existing = repo.findById(id).orElseThrow(()-> new DomainException("Aeronave não encontrada: " + id));

        if (!existing.getName().equalsIgnoreCase(name) && repo.findByName(name).isPresent()) {
            throw new DomainException("Aeronave já existe: " + name);
        }
        existing.setName(name);
        repo.save(existing);
        return toDTO(existing);
    }

    public AircraftDTO getById(String id){
        return repo.findById(id).map(this::toDTO).orElse(null);
    }

    public List<AircraftDTO> listAll(){
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public void delete(String id){
        if (repo.findById(id).isEmpty()) throw new DomainException("Aeronave não encontrada:" + id);
        repo.deleteById(id);
    }

    private AircraftDTO toDTO(Aircraft at){
        return new AircraftDTO(at.getId(), at.getName());
    }
}
