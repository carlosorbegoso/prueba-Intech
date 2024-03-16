package com.Intech.prueba.infrastructure.adpter.mongodb.repository;

import com.Intech.prueba.infrastructure.adpter.mongodb.document.UserDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserReactiveMongoRepository extends ReactiveMongoRepository<UserDocument,String> {
    Mono<UserDocument> findByEmail(String email);

}
