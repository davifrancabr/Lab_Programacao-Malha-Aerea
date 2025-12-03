package com.malha.domain.model;

import java.util.Objects;

public class ICAOCode {
    private final String code;

    public ICAOCode(String code) {
        if (code == null) throw new IllegalArgumentException("Código ICAO não pode ser nulo.");
        String normalized = code.trim().toUpperCase();
        if (!normalized.matches("^[A-Z]{4}$")) {
            throw new IllegalArgumentException("Formado inválido de código ICAO. Esperava r letras(A-Z). Fornecido: " + code);
        }
        this.code = normalized;
    }

    public String getCode() { return code; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ICAOCode)) return false;
        ICAOCode icaoCode = (ICAOCode) o;
        return code.equals(icaoCode.code);
    }
    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
    @Override
    public String toString() {
        return code;
    }
}
