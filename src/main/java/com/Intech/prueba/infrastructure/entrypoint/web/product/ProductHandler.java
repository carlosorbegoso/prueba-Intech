package com.Intech.prueba.infrastructure.entrypoint.web.product;

import com.Intech.prueba.domain.model.dto.ProductCreateDto;
import com.Intech.prueba.domain.model.dto.ProductUpdateDto;
import com.Intech.prueba.domain.model.product.gateway.ProductGateway;
import com.Intech.prueba.infrastructure.adpter.mongodb.document.ProductDocument;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {
    ProductGateway productGateway;


    public ProductHandler(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }


    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productGateway.findAll(), ProductDocument.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {

        return request.bodyToMono(ProductCreateDto.class)
                .flatMap(dto -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(productGateway.save(dto), ProductDocument.class));
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    public  Mono<ServerResponse> delete(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productGateway.deleteById(request.pathVariable("id")), ProductDocument.class);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    public Mono<ServerResponse> update(ServerRequest request){
        return request.bodyToMono(ProductUpdateDto.class)
                .flatMap(dto -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(productGateway.update(request.pathVariable("id"),dto), ProductDocument.class));
    }


}
