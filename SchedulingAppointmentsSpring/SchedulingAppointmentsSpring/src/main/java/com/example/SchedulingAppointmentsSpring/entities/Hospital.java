package com.example.SchedulingAppointmentsSpring.entities;

import com.example.SchedulingAppointmentsSpring.entities.user.Doctor;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;

@Table(name = "tb_appointment")
@Entity(name = "tb_appointment")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;
    private String cep;
    private String address;

    @OneToMany(mappedBy = "hospital")
    private HashSet<Doctor> doctors = new HashSet<>();

}
