package com.example.SchedulingAppointmentsSpring.controllers;

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
import org.springframework.http.HttpStatus;
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

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        User user = (User) repository.findByLogin(data.login());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User doesn't exists");
        }

         if (!passwordEncoder.matches(data.password(), user.getPassword())) {
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login or password");
         }

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.repository.findByLogin(data.login()) != null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Users already exists");

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        if (data.role().name().equals(UserRole.DOCTOR.name())) {
            Doctor doctor = new Doctor(data.login(), data.phone(), data.email(), encryptedPassword, UserRole.DOCTOR, data.speciallity(), data.academicDegree(), null);
            this.repository.save(doctor);
            return ResponseEntity.ok().body("Doutor criado com sucesso!");
        }

        if (data.role().name().equals(UserRole.PACIENT.name())) {
            Pacient pacient = new Pacient(data.login(), data.phone(), data.email(), encryptedPassword, UserRole.PACIENT, data.age(), data.address(), data.height(), data.allergy(), data.allergyType());
            this.repository.save(pacient);
            return ResponseEntity.ok().body("Paciente criado com sucesso!");
        }

        return ResponseEntity.badRequest().build();

    }

}
