package com.Intech.prueba.domain.model.product.gateway;

import com.Intech.prueba.domain.model.dto.ProductCreateDto;
import com.Intech.prueba.domain.model.dto.ProductUpdateDto;
import com.Intech.prueba.infrastructure.adpter.mongodb.document.ProductDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductGateway {
    Flux<ProductDocument> findAll();
    Mono<ProductDocument> findById(String id);
    Mono<ProductCreateDto> save(ProductCreateDto productCreateDto);
    Mono<ProductUpdateDto> update(String id, ProductUpdateDto productUpdateDto);
    Mono<Void> deleteById(String id);

}
