package com.Intech.prueba.infrastructure.entrypoint.web.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
/**
 * This class is responsible for routing HTTP requests related to authentication to the appropriate handler methods.
 * It uses the Spring Framework's RouterFunctions for routing.
 */
@Configuration
public class RouterAuth {
    // The base path for all authentication-related routes
    private static final String PATH = "auth/";
    /**
     * Defines the routes for authentication-related HTTP requests.
     *
     * @param authHandler The handler that contains the methods to be called when a route is matched.
     * @return A RouterFunction that routes requests to the appropriate handler methods.
     */
    @Bean
    public RouterFunction<ServerResponse> authRoute(AuthHandler authHandler) {
        return RouterFunctions.route()
                // Route for signing up a new user
                .POST(PATH + "signup", authHandler::signUp)
                // Route for logging in a user
                .POST(PATH + "login", authHandler::logIn)
                .build();
    }
}