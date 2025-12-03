package com.malha.domain.model;

import java.util.Objects;
import java.util.UUID;

public class AircraftType {
    private final String id;
    private String name;

    public AircraftType(String name) {
        this.id = UUID.randomUUID().toString();
        setName(name);
    }

    public AircraftType(String id, String name) {
        this.id = id;
        setName(name);
    }

    public String getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Nome da aeronave não pode ser vazio.");

        String normalized = name.trim();

        if (!normalized.matches("^[A-Za-z0-9 .\\-/]+$")) {
            throw new IllegalArgumentException("Formatp inválido. caracteres permitidos: letras, numeros, espacos, ., -, /");
        }
        this.name = normalized;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AircraftType)) return false;
        AircraftType that = (AircraftType) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return String.format("[%s] %s", id, name);
    }
}
