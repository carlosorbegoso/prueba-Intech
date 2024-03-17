package com.Intech.prueba.infrastructure.adpter.mongodb.repository;

import com.Intech.prueba.infrastructure.adpter.mongodb.document.ProductDocument;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductReactiveMongoRepository extends ReactiveCrudRepository<ProductDocument,String> {
}
