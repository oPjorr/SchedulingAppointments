package com.example.SchedulingAppointmentsSpring.entities.DTO;

import jakarta.validation.constraints.NotNull;

public record AuthenticationDTO(@NotNull String login, @NotNull String password) {
}
