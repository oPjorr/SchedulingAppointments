package com.example.SchedulingAppointmentsSpring.entities.enums;

import lombok.Getter;

@Getter
public enum AllergyType {
    FEED("FEED"),
    EYEPIECE("EYEPIECE"),
    SKIN("SKIN"),
    NOSE("NOSE"),
    RESPIRATORY("RESPIRATORY");

    private final String role;

    AllergyType(String role) {
        this.role = role;
    }
}
