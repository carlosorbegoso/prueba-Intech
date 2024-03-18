package com.Intech.prueba.infrastructure.entrypoint.web.product;

import com.Intech.prueba.domain.model.dto.ProductCreateDto;
import com.Intech.prueba.domain.model.dto.ProductUpdateDto;
import com.Intech.prueba.domain.model.product.gateway.ProductGateway;
import com.Intech.prueba.infrastructure.adpter.kafka.producer.KafkaProducer;
import com.Intech.prueba.infrastructure.adpter.mongodb.document.ProductDocument;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
/**
 * This class handles the HTTP requests related to products.
 * It uses the ProductGateway to interact with the database and KafkaProducer to send messages to Kafka.
 */
@Component
public class ProductHandler {
    // Gateway to interact with the product data in the database
    ProductGateway productGateway;
    // Kafka producer to send messages to Kafka
    private final KafkaProducer kafkaProducer;

    /**
     * Constructor for the ProductHandler class.
     *
     * @param productGateway The gateway to interact with the product data in the database.
     * @param kafkaProducer The Kafka producer to send messages to Kafka.
     */
    public ProductHandler(ProductGateway productGateway, KafkaProducer kafkaProducer) {
        this.productGateway = productGateway;
        this.kafkaProducer = kafkaProducer;
    }

    /**
     * Handles the HTTP GET request to fetch all products.
     *
     * @param request The incoming server request.
     * @return A Mono of ServerResponse with HTTP status 200 (OK) and all the products in the body.
     */
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productGateway.findAll(), ProductDocument.class);
    }
    /**
     * Handles the HTTP POST request to create a new product.
     *
     * @param request The incoming server request.
     * @return A Mono of ServerResponse. If the product is successfully created, it returns a ServerResponse with HTTP status 200 (OK) and the created product in the body. If there is an error during the creation of the product, it returns an error response.
     */
    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(ProductCreateDto.class)
                .flatMap(dto -> productGateway.save(dto)
                        .doOnSuccess(product -> kafkaProducer.sendMessage("Product created: " + product.name()))
                        .flatMap(product -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(product)));
    }
    /**
     /**
     * Handles the HTTP DELETE request to delete a product by its ID.
     * This method is only accessible to users with the 'ADMIN' authority.
     *
     * @param request The incoming server request.
     * @return A Mono of ServerResponse with HTTP status 200 (OK) and the deleted product in the body.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    public  Mono<ServerResponse> delete(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productGateway.deleteById(request.pathVariable("id")), ProductDocument.class);
    }
    /**
     * Handles the HTTP PUT request to update a product by its ID.
     * This method is only accessible to users with the 'ADMIN' authority.
     *
     * @param request The incoming server request.
     * @return A Mono of ServerResponse with HTTP status 200 (OK) and the updated product in the body.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    public Mono<ServerResponse> update(ServerRequest request){
        return request.bodyToMono(ProductUpdateDto.class)
                .flatMap(dto -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(productGateway.update(request.pathVariable("id"),dto), ProductDocument.class));
    }


}
