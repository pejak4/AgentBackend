package com.example.agentbackend.model;

import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
public enum UserRole {

    ADMIN("ADMIN"), USER("USER"), AGENT("AGENT"), FIRM("FIRM");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}
