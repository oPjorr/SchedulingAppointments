package com.example.SchedulingAppointmentsSpring.entities.DTO;

import com.example.SchedulingAppointmentsSpring.entities.Hospital;
import com.example.SchedulingAppointmentsSpring.entities.enums.HealthAcademicDegree;
import com.example.SchedulingAppointmentsSpring.entities.enums.UserRole;
import jakarta.validation.constraints.NotNull;

public record DoctorDTO(
        @NotNull String login,
        @NotNull String password,
        @NotNull String email,
        @NotNull String phone,
        @NotNull UserRole role,
        String speciallity,
        HealthAcademicDegree academicDegree,
        Hospital hospital) {
}
