package com.Intech.prueba.domain.usescase;

import com.Intech.prueba.domain.model.dto.LogInDTO;
import com.Intech.prueba.domain.model.dto.TokenDTO;
import com.Intech.prueba.domain.model.user.gateway.UserGateway;
import reactor.core.publisher.Mono;

public class LogInUseCase {
    private final UserGateway userGateway;

    public LogInUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public Mono<TokenDTO> login(LogInDTO dto) {
        return userGateway.login(dto);
    }
}
