package com.example.SchedulingAppointmentsSpring.entities.DTO;

import com.example.SchedulingAppointmentsSpring.entities.Hospital;
import com.example.SchedulingAppointmentsSpring.entities.enums.HealthAcademicDegree;

public record DoctorDTO(String id, String login, String phone, String email, String password, String speciallity, HealthAcademicDegree academicDegree, Hospital hospital) {
}
