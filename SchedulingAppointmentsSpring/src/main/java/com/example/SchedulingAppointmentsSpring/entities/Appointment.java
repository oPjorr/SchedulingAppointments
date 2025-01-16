package com.example.SchedulingAppointmentsSpring.entities;

import com.example.SchedulingAppointmentsSpring.entities.enums.AppointmentCause;
import com.example.SchedulingAppointmentsSpring.entities.enums.AppointmentRole;
import com.example.SchedulingAppointmentsSpring.entities.user.Doctor;
import com.example.SchedulingAppointmentsSpring.entities.user.Pacient;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "tb_appointment")
@Entity(name = "tb_appointment")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private AppointmentCause cause;
    private String description;
    private Date dateStart;
    private Date dateEnd;
    private AppointmentRole status;

    @ManyToOne
    @JoinColumn(name = "pacient_id")
    private Pacient pacient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Appointment(Long id, AppointmentCause cause, String description, Date dateStart,
                       Date dateEnd, Doctor doctor, Pacient pacient, AppointmentRole status) {
        this.id = id;
        this.cause = cause;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.doctor = doctor;
        this.pacient = pacient;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppointmentCause getCause() {
        return cause;
    }

    public void setCause(AppointmentCause cause) {
        this.cause = cause;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public AppointmentRole getStatus() {
        return status;
    }

    public void setStatus(AppointmentRole status) {
        this.status = status;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
