package com.example.SchedulingAppointmentsSpring.entities.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum AppointmentRole {
    CANCELED("CANCELED"),
    FINISHED("FINISHED"),
    CONFIRMED("CONFIRMED");

    private String role;

    AppointmentRole(String role) {
        this.role = role;
    }
}
