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

    public String getSpeciallity() {
        return speciallity;
    }

    public void setSpeciallity(String speciallity) {
        this.speciallity = speciallity;
    }

    public HealthAcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(HealthAcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}
