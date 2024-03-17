package com.Intech.prueba.infrastructure.entrypoint.web.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterAuth {

    private static final String PATH = "auth/";

    @Bean
    public RouterFunction<ServerResponse> authRoute(AuthHandler authHandler) {
        return RouterFunctions.route()
                .POST(PATH + "signup", authHandler::signUp)
                .POST(PATH + "login", authHandler::logIn)
                .build();
    }
}