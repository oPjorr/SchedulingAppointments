package com.example.SchedulingAppointmentsSpring.controllers;

import com.example.SchedulingAppointmentsSpring.controllers.exceptions.ResourceExceptionHandler;
import com.example.SchedulingAppointmentsSpring.entities.DTO.AuthenticationDTO;
import com.example.SchedulingAppointmentsSpring.entities.DTO.LoginResponseDTO;
import com.example.SchedulingAppointmentsSpring.entities.DTO.RegisterDTO;
import com.example.SchedulingAppointmentsSpring.entities.enums.UserRole;
import com.example.SchedulingAppointmentsSpring.entities.user.Doctor;
import com.example.SchedulingAppointmentsSpring.entities.user.Pacient;
import com.example.SchedulingAppointmentsSpring.entities.user.User;
import com.example.SchedulingAppointmentsSpring.repositories.UserRepository;
import com.example.SchedulingAppointmentsSpring.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        if (data.role().name().equals(UserRole.DOCTOR.name())) {
            Doctor doctor = new Doctor(data.login(), encryptedPassword, data.email(), data.phone(), UserRole.DOCTOR, data.speciallity(), data.academicDegree(), null);
            this.repository.save(doctor);
            return ResponseEntity.ok().build();

        }

        if (data.role().name().equals(UserRole.PACIENT.name())) {
            Pacient pacient = new Pacient(data.login(), encryptedPassword, data.email(), data.phone(), UserRole.PACIENT, data.age(), data.address(), data.height(), data.allergy(), data.allergyType());
            this.repository.save(pacient);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();

    }

}
