package com.example.SchedulingAppointmentsSpring.entities.DTO;

import com.example.SchedulingAppointmentsSpring.entities.user.Doctor;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record HospitalDTO(Long id, @NotNull String name, @NotNull String cep, @NotNull String address, Set<Doctor> doctors) {
}
