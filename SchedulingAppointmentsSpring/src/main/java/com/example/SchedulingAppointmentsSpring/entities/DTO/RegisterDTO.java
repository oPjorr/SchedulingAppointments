package com.example.SchedulingAppointmentsSpring.entities.DTO;

import com.example.SchedulingAppointmentsSpring.entities.enums.AllergyType;
import com.example.SchedulingAppointmentsSpring.entities.enums.HealthAcademicDegree;
import com.example.SchedulingAppointmentsSpring.entities.enums.UserRole;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
        @NotNull String login,
        @NotNull String password,
        @NotNull String email,
        @NotNull String phone,
        @NotNull UserRole role,
        String speciallity,
        HealthAcademicDegree academicDegree,
        int age, String address,
        double height,
        boolean allergy,
        AllergyType allergyType) {
}
