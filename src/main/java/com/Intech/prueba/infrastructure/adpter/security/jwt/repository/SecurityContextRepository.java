package com.Intech.prueba.infrastructure.adpter.security.jwt.repository;

import com.Intech.prueba.infrastructure.adpter.security.jwt.manage.JwtAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
/**
 * This class is responsible for managing the security context of the application.
 * It uses the Spring Framework's ServerSecurityContextRepository interface to define a repository that loads and saves the security context of the application.
 */
@Component
public class SecurityContextRepository implements ServerSecurityContextRepository {

    private final JwtAuthenticationManager jwtAuthenticationManager;

    public SecurityContextRepository(JwtAuthenticationManager jwtAuthenticationManager) {
        this.jwtAuthenticationManager = jwtAuthenticationManager;
    }

    @Override
    public Mono<Void> save(ServerWebExchange exchange, SecurityContext context) {
        return Mono.empty();
    }

    @Override
    public Mono<SecurityContext> load(ServerWebExchange exchange) {
        String token = exchange.getAttribute("token");
        return jwtAuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(token, token))
                .map(SecurityContextImpl::new);
    }
}