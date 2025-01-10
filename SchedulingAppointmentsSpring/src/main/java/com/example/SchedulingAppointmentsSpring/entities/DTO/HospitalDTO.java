package com.example.SchedulingAppointmentsSpring.entities.DTO;

import com.example.SchedulingAppointmentsSpring.entities.user.Doctor;

import java.util.HashSet;

public record HospitalDTO(String id, String name, String cep, String address, HashSet<Doctor> doctors) {
}
