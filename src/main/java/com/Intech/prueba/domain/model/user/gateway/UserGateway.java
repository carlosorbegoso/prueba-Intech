package com.Intech.prueba.domain.model.user.gateway;

import com.Intech.prueba.domain.model.dto.LogInDTO;
import com.Intech.prueba.domain.model.dto.SignUpDTO;
import com.Intech.prueba.domain.model.dto.TokenDTO;
import com.Intech.prueba.domain.model.user.User;
import reactor.core.publisher.Mono;

public interface UserGateway {
    Mono<User> signUp(SignUpDTO dto);
    Mono<TokenDTO> login(LogInDTO dto);

}