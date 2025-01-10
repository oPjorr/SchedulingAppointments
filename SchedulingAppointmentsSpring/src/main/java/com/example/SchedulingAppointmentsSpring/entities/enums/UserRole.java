package com.example.SchedulingAppointmentsSpring.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum UserRole {
    USER("user"),

    ADMIN("admin"),

    DOCTOR("doctor"),

    PACIENT("pacient");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}
