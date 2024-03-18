package com.Intech.prueba.infrastructure.adpter.mongodb.adapter;

import com.Intech.prueba.domain.model.dto.ProductCreateDto;
import com.Intech.prueba.domain.model.dto.ProductUpdateDto;
import com.Intech.prueba.domain.model.product.gateway.ProductGateway;
import com.Intech.prueba.infrastructure.adpter.mongodb.document.ProductDocument;
import com.Intech.prueba.infrastructure.adpter.mongodb.repository.ProductReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * This class is responsible for interacting with the product data in the MongoDB database.
 * It implements the ProductGateway interface and uses a ProductReactiveMongoRepository for database operations.
 *
 */
@Repository
public class ProductMongoAdapter implements ProductGateway {
    private final ProductReactiveMongoRepository productReactiveMongoRepository;
    /**
     * Constructor for the ProductMongoAdapter class.
     *
     * @param productReactiveMongoRepository The repository for performing database operations.
     */
    public ProductMongoAdapter(ProductReactiveMongoRepository productReactiveMongoRepository) {
        this.productReactiveMongoRepository = productReactiveMongoRepository;
    }

    @Override
    public Flux<ProductDocument> findAll() {
        return productReactiveMongoRepository.findAll();
    }

    @Override
    public Mono<ProductDocument> findById(String id) {
        return productReactiveMongoRepository.findById(id);
    }

    @Override
    public Mono<ProductCreateDto> save(ProductCreateDto productCreateDto) {
        var productDocument = getProductDocument(productCreateDto);
        return productReactiveMongoRepository.save(productDocument)
                .map(productDocument1 -> productCreateDto);
    }

    @Override
    public Mono<ProductUpdateDto> update(String id, ProductUpdateDto productUpdateDto) {
        return productReactiveMongoRepository.findById(id)
                .map(productDocument -> {
                    productDocument.setName(productUpdateDto.name());
                    productDocument.setPrice(productUpdateDto.price());
                    productDocument.setStock(productUpdateDto.stock());
                    return productDocument;
                })
                .flatMap(productReactiveMongoRepository::save)
                .map(productDocument -> productUpdateDto);

    }

    private ProductDocument getProductDocument(ProductCreateDto productCreateDto) {
        return new ProductDocument(
                null,
                productCreateDto.name(),
                productCreateDto.price(),
                productCreateDto.stock()
        );
    }



    @Override
    public Mono<Void> deleteById(String id) {
        return productReactiveMongoRepository.deleteById(id);
    }
}
