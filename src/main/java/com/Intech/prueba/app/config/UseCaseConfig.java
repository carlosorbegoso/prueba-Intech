package com.Intech.prueba.app.config;


import com.Intech.prueba.domain.model.user.gateway.UserGateway;
import com.Intech.prueba.domain.usescase.login.LogInUseCase;
import com.Intech.prueba.domain.usescase.login.SignUpUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public SignUpUseCase signUpUseCase(UserGateway userGateway) {
        return new SignUpUseCase(userGateway);
    }

    @Bean
    public LogInUseCase logInUseCase(UserGateway userGateway) {
        return new LogInUseCase(userGateway);
    }
}