package com.Intech.prueba.domain.model.dto;

public record ProductUpdateDto(
        String name,
        String description,
        Double price,
        Integer stock) {
}
