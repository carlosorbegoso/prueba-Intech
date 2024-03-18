package com.Intech.prueba.infrastructure.adpter.mongodb.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * This class represents a User document in MongoDB.
 * It is annotated with @Document to indicate that it is a MongoDB document.
 * It uses Lombok annotations for automatic generation of getters and setters.
 * It implements UserDetails interface for Spring Security integration.
 */
@Setter
@Getter
@Document
public class UserDocument implements UserDetails {

    private String id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Boolean status;
    private String roles;

    public UserDocument() {}

    public UserDocument(String id, String name, String lastName, String email, String password, Boolean status, String roles) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.status = status;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(roles.split(", ")).map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return status;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return status;
    }

    @Override
    public boolean isEnabled() {
        return status;
    }

    @Override
    public String toString() {
        return "UserDocument{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", roles='" + roles + '\'' +
                '}';
    }
}
