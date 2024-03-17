package com.Intech.prueba.infrastructure.adpter.mongodb.mapper;

import com.Intech.prueba.domain.model.product.Product;
import com.Intech.prueba.infrastructure.adpter.mongodb.document.ProductDocument;

public class ProductMapper {

    private ProductMapper() {}

    public static Product mapToModel(ProductDocument productDocument) {
        return new Product(productDocument.getId(),
                productDocument.getName(),
                productDocument.getPrice(),
                productDocument.getStock());
    }

    public static ProductDocument mapToModel(Product product) {
        return new ProductDocument(product.id(),
                product.name(),
                product.price(),
                product.stock());
    }
}
