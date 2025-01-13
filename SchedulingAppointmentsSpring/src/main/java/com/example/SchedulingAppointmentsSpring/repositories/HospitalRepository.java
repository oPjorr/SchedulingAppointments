package com.example.SchedulingAppointmentsSpring.repositories;

import com.example.SchedulingAppointmentsSpring.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {}
