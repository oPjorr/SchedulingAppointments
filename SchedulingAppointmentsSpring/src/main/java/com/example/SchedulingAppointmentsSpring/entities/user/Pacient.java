package com.example.SchedulingAppointmentsSpring.entities.user;

import com.example.SchedulingAppointmentsSpring.entities.Appointment;
import com.example.SchedulingAppointmentsSpring.entities.enums.AllergyType;
import com.example.SchedulingAppointmentsSpring.entities.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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
    Set<Appointment> appointments = new HashSet<>();

    public Pacient(String login, String phone, String email, String password, UserRole role,
                   int age, String address, double height, boolean allergy, AllergyType allergyType) {
        super(login, phone, email, password, role);
        this.age = age;
        this.address = address;
        this.height = height;
        this.allergy = allergy;
        this.allergyType = allergyType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isAllergy() {
        return allergy;
    }

    public void setAllergy(boolean allergy) {
        this.allergy = allergy;
    }

    public AllergyType getAllergyType() {
        return allergyType;
    }

    public void setAllergyType(AllergyType allergyType) {
        this.allergyType = allergyType;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}
