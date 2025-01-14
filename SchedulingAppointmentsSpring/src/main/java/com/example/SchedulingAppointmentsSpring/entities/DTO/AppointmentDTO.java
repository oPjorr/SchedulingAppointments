package com.example.SchedulingAppointmentsSpring.entities.DTO;

import com.example.SchedulingAppointmentsSpring.entities.enums.AppointmentCause;
import com.example.SchedulingAppointmentsSpring.entities.enums.AppointmentRole;
import com.example.SchedulingAppointmentsSpring.entities.user.Doctor;
import com.example.SchedulingAppointmentsSpring.entities.user.Pacient;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record AppointmentDTO(Long id,
        @NotNull  AppointmentCause cause,
        @NotNull String description,
        @NotNull Doctor doctor,
        @NotNull Date dateStart,
        @NotNull Date dateEnd,
        @NotNull AppointmentRole status,
        @NotNull Pacient pacient) {
}
