package com.example.SchedulingAppointmentsSpring.repositories;

import com.example.SchedulingAppointmentsSpring.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
