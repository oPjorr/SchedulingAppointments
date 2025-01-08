package com.example.SchedulingAppointmentsSpring.entities.user;

import com.example.SchedulingAppointmentsSpring.entities.Appointment;
import com.example.SchedulingAppointmentsSpring.entities.Hospital;
import com.example.SchedulingAppointmentsSpring.entities.enums.HealthAcademicDegree;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;

@Entity(name = "tb_doctor")
@PrimaryKeyJoinColumn(name="doctor_id", referencedColumnName = "id")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends User {

    private String speciallity;
    private HealthAcademicDegree academicDegree;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor")
    private HashSet<Appointment> appointments = new HashSet<>();
}
