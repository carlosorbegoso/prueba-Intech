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

@Component
public class AuthHandler {

    private final SignUpUseCase signUpUseCase;
    private final LogInUseCase logInUseCase;

    public AuthHandler(SignUpUseCase signUpUseCase, LogInUseCase logInUseCase) {
        this.signUpUseCase = signUpUseCase;
        this.logInUseCase = logInUseCase;
    }


    public Mono<ServerResponse> signUp(ServerRequest request) {

        return request.bodyToMono(SignUpDTO.class)
                .flatMap(dto -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(signUpUseCase.signUp(dto), User.class));
    }

    public Mono<ServerResponse> logIn(ServerRequest request) {

        return request.bodyToMono(LogInDTO.class)
                .flatMap(dto -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(logInUseCase.login(dto), TokenDTO.class));
    }

}