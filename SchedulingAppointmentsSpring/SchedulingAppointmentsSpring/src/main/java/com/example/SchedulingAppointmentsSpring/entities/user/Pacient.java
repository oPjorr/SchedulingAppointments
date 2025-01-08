package com.example.SchedulingAppointmentsSpring.entities.user;

import com.example.SchedulingAppointmentsSpring.entities.Appointment;
import com.example.SchedulingAppointmentsSpring.entities.enums.AllergyType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;

@Entity(name = "tb_pacient")
@PrimaryKeyJoinColumn(name="pacient_id", referencedColumnName = "id")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pacient extends User {

    private int age;
    private String address;
    private double height;
    private boolean allergy;
    private AllergyType allergyType;

    @OneToMany(mappedBy = "pacient")
    private HashSet<Appointment> appointments = new HashSet<>();
}
