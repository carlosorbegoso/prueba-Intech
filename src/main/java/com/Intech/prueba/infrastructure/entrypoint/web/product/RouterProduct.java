package com.Intech.prueba.infrastructure.entrypoint.web.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterProduct {
    private static final String PATH = "product/";

    @Bean
    public RouterFunction<ServerResponse> productRoute(ProductHandler productHandler) {
        return RouterFunctions.route()
                .GET(PATH + "all", productHandler::findAll)
                .POST(PATH + "save", productHandler::save)
                .PUT(PATH + "update/{id}", productHandler::update)
                .DELETE(PATH + "deleteById/{id}", productHandler::delete)
                .build();
    }
}
