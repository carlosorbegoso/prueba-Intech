package com.Intech.prueba.domain.usescase;

import com.Intech.prueba.domain.model.dto.SignUpDTO;
import com.Intech.prueba.domain.model.user.User;
import com.Intech.prueba.domain.model.user.gateway.UserGateway;
import reactor.core.publisher.Mono;

public class SignUpUseCase {
    private final UserGateway userGateway;


    public SignUpUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public Mono<User> signUp(SignUpDTO dto) {
        return userGateway.signUp(dto);
    }
}
