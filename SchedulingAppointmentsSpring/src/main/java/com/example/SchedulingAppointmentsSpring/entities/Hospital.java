package com.example.SchedulingAppointmentsSpring.entities;

import com.example.SchedulingAppointmentsSpring.entities.user.Doctor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany(mappedBy = "hospital")
    private Set<Doctor> doctors = new HashSet<>();

    public Hospital(Long id, String name, String cep, String address, Set<Doctor> doctors) {
        this.id = id;
        this.name = name;
        this.cep = cep;
        this.address = address;
        this.doctors = doctors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }
}
