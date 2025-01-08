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
}
