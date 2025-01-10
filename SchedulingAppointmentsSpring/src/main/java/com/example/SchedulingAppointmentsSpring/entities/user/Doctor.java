package com.example.SchedulingAppointmentsSpring.entities.user;

import com.example.SchedulingAppointmentsSpring.entities.Appointment;
import com.example.SchedulingAppointmentsSpring.entities.Hospital;
import com.example.SchedulingAppointmentsSpring.entities.enums.HealthAcademicDegree;
import com.example.SchedulingAppointmentsSpring.entities.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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
    private Set<Appointment> appointments = new HashSet<>();

    public Doctor(String login, String phone, String email, String password, UserRole role, String speciallity, HealthAcademicDegree academicDegree, Hospital hospital) {
        super(login, phone, email, password, role);
        this.speciallity = speciallity;
        this.academicDegree = academicDegree;
        this.hospital = hospital;
    }
}
