package com.example.SchedulingAppointmentsSpring.entities.DTO;

import com.example.SchedulingAppointmentsSpring.entities.enums.AppointmentCause;
import com.example.SchedulingAppointmentsSpring.entities.enums.AppointmentRole;
import com.example.SchedulingAppointmentsSpring.entities.user.Doctor;
import com.example.SchedulingAppointmentsSpring.entities.user.Pacient;

import java.util.Date;

public record AppointmentDTO(Long id, AppointmentCause cause, String description, Doctor doctor, Date dateStart, Date dateEnd, AppointmentRole status, Pacient pacient) {
}
