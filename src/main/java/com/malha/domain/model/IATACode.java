package com.malha.domain.model;

import java.util.Objects;

public class IATACode {
    private final String code;

    public IATACode(String code){
        if (code == null) throw new IllegalArgumentException("Código IATA não pode ser nulo.");
        String normalized = code.trim().toUpperCase();
        if (!normalized.matches("^[A-Z]{3}$")) {
            throw new IllegalArgumentException("Formado inválido de código IATA. Esperava 3 letras(A-Z). Fornecido: " + code);
        }
        this.code = normalized;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IATACode)) return false;
        IATACode iataCode = (IATACode) o;
        return code.equals(iataCode.code);
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
