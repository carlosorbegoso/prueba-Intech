package com.Intech.prueba.domain.model.product;

public record Product (
        String id,
        String name,
        Double price,
        Integer stock
){
}
