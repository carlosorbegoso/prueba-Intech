package com.Intech.prueba.infrastructure.entrypoint.web.auth;

import com.Intech.prueba.domain.model.dto.LogInDTO;
import com.Intech.prueba.domain.model.dto.SignUpDTO;
import com.Intech.prueba.domain.model.dto.TokenDTO;
import com.Intech.prueba.domain.model.user.User;
import com.Intech.prueba.domain.usescase.login.LogInUseCase;
import com.Intech.prueba.domain.usescase.login.SignUpUseCase;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
/**
 * This class is responsible for routing HTTP requests related to products to the appropriate handler methods.
 * It uses the Spring Framework's RouterFunctions for routing.
 */
@Component
public class AuthHandler {
    // Use case for handling sign up requests
    private final SignUpUseCase signUpUseCase;
    // Use case for handling log in requests
    private final LogInUseCase logInUseCase;
    /**
     * Constructor for the AuthHandler class.
     *
     * @param signUpUseCase The use case for handling sign up requests.
     * @param logInUseCase The use case for handling log in requests.
     */
    public AuthHandler(SignUpUseCase signUpUseCase, LogInUseCase logInUseCase) {
        this.signUpUseCase = signUpUseCase;
        this.logInUseCase = logInUseCase;
    }

    /**
     * Handles the HTTP POST request to sign up a new user.
     *
     * @param request The incoming server request.
     * @return A Mono of ServerResponse. If the user is successfully signed up, it returns a ServerResponse with HTTP status 200 (OK) and the created user in the body. If there is an error during the sign up, it returns an error response.
     */
    public Mono<ServerResponse> signUp(ServerRequest request) {

        return request.bodyToMono(SignUpDTO.class)
                .flatMap(dto -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(signUpUseCase.signUp(dto), User.class));
    }
    /**
     * Handles the HTTP POST request to log in a user.
     *
     * @param request The incoming server request.
     * @return A Mono of ServerResponse. If the user is successfully logged in, it returns a ServerResponse with HTTP status 200 (OK) and a TokenDTO in the body. If there is an error during the log in, it returns an error response.
     */
    public Mono<ServerResponse> logIn(ServerRequest request) {

        return request.bodyToMono(LogInDTO.class)
                .flatMap(dto -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(logInUseCase.login(dto), TokenDTO.class));
    }

}