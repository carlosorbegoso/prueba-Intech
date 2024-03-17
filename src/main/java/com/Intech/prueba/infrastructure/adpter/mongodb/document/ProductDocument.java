package com.Intech.prueba.infrastructure.adpter.mongodb.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
@AllArgsConstructor
public class ProductDocument {
    private String id;
    private String name;
    private Double price;
    private Integer stock;


}
