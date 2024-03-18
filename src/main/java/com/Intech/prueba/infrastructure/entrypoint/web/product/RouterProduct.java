package com.Intech.prueba.infrastructure.entrypoint.web.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
/**
 * This class is responsible for routing HTTP requests related to products to the appropriate handler methods.
 * It uses the Spring Framework's RouterFunctions for routing.
 */
@Configuration
public class RouterProduct {
    // The base path for all product-related routes
    private static final String PATH = "product/";
    /**
     * Defines the routes for product-related HTTP requests.
     *
     * @param productHandler The handler that contains the methods to be called when a route is matched.
     * @return A RouterFunction that routes requests to the appropriate handler methods.
     */
    @Bean
    public RouterFunction<ServerResponse> productRoute(ProductHandler productHandler) {
        return RouterFunctions.route()
                // Route for getting all products
                .GET(PATH + "all", productHandler::findAll)
                // Route for creating a new product
                .POST(PATH + "save", productHandler::save)
                // Route for updating a product by its ID
                .PUT(PATH + "update/{id}", productHandler::update)
                // Route for deleting a product by its ID
                .DELETE(PATH + "deleteById/{id}", productHandler::delete)
                .build();
    }
}
