package com.example.SchedulingAppointmentsSpring.entities.DTO;

import com.example.SchedulingAppointmentsSpring.entities.enums.AllergyType;
import com.example.SchedulingAppointmentsSpring.entities.enums.UserRole;
import jakarta.validation.constraints.NotNull;

public record PacientDTO(
        @NotNull String login,
        @NotNull String password,
        @NotNull String email,
        @NotNull String phone,
        @NotNull UserRole role,
        @NotNull int age,
        @NotNull String address,
        @NotNull double height,
        @NotNull boolean allergy,
        AllergyType allergyType) {
}
