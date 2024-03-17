package com.Intech.prueba.domain.model.dto;

public record ProductCreateDto(
        String name,
        String description,
        Double price,
        Integer stock
) {
}
