package com.example.SchedulingAppointmentsSpring.entities.user;

import com.example.SchedulingAppointmentsSpring.entities.Hospital;
import com.example.SchedulingAppointmentsSpring.entities.enums.HealthAcademicDegree;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_doctor")
@Entity(name = "tb_doctor")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends User{
    private String speciallity;
    private HealthAcademicDegree academicDegree;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
