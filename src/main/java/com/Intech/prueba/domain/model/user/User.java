package com.Intech.prueba.domain.model.user;

public record User(String id,
                   String name,
                   String lastName,
                   String email,
                   String password,
                   Boolean status,
                   String roles) {}