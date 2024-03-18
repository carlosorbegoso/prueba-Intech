package com.Intech.prueba.infrastructure.adpter.mongodb.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * This class represents a Product document in MongoDB.
 * It is annotated with @Document to indicate that it is a MongoDB document.
 * It uses Lombok annotations for automatic generation of getters, setters and a constructor.
 */
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
