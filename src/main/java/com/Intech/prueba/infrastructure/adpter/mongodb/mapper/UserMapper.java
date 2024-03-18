package com.Intech.prueba.infrastructure.adpter.mongodb.mapper;

import com.Intech.prueba.domain.model.user.User;
import com.Intech.prueba.infrastructure.adpter.mongodb.document.UserDocument;

/**
 * This class represents a User document in MongoDB.
 * It is annotated with @Document to indicate that it is a MongoDB document.
 * It uses Lombok annotations for automatic generation of getters and setters.
 * It implements UserDetails interface for Spring Security integration.
 */
public class UserMapper {
    /**
     * Private constructor to prevent instantiation.
     */
    private UserMapper() {}
    /**
     * Maps a UserDocument object to a User object.
     * @param userDocument The UserDocument object to be converted.
     * @return A User object that represents the same data as the input UserDocument.
     */
    public static User mapToModel(UserDocument userDocument) {
        return new User(userDocument.getId(),
                userDocument.getName(),
                userDocument.getLastName(),
                userDocument.getEmail(),
                userDocument.getPassword(),
                userDocument.getStatus(),
                userDocument.getRoles());
    }
    /**
     * Maps a User object to a UserDocument object.
     * @param user The User object to be converted.
     * @return A UserDocument object that represents the same data as the input User.
     */
    public static UserDocument mapToModel(User user) {
        return new UserDocument(user.id(),
                user.name(),
                user.lastName(),
                user.email(),
                user.password(),
                user.status(),
                user.roles());
    }
}