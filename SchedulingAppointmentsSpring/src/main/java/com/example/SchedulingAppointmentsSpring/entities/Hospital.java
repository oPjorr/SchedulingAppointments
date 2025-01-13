package com.example.SchedulingAppointmentsSpring.entities;

import com.example.SchedulingAppointmentsSpring.entities.user.Doctor;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;

@Table(name = "tb_hospital")
@Entity(name = "tb_hospital")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cep;
    private String address;

    @OneToMany(mappedBy = "hospital")
    private HashSet<Doctor> doctors = new HashSet<>();

    public Hospital(Long id, String name, String cep, String address) {
        this.id = id;
        this.name = name;
        this.cep = cep;
        this.address = address;
    }
}
