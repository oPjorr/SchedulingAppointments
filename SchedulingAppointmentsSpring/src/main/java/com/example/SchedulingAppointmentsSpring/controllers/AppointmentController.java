package com.example.SchedulingAppointmentsSpring.controllers;

import com.example.SchedulingAppointmentsSpring.entities.DTO.AppointmentDTO;
import com.example.SchedulingAppointmentsSpring.entities.user.Doctor;
import com.example.SchedulingAppointmentsSpring.entities.user.Pacient;
import com.example.SchedulingAppointmentsSpring.services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    AppointmentService service;

//    Teste
    @GetMapping("/doctor")
    public String doctorInfo(@AuthenticationPrincipal Doctor doctor) {
        return "Doctor info: "; // + doctor.getSpeciallity();
    }

    @GetMapping("/pacient")
    public String pacientInfo(@AuthenticationPrincipal Pacient pacient) {
        return "Pacient info: "; // + pacient.getAge();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AppointmentDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AppointmentDTO insert(@Valid @RequestBody AppointmentDTO obj) {
        return service.insert(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deletado com sucesso!");
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentDTO update(@PathVariable Long id, @Valid @RequestBody AppointmentDTO obj) {
        return service.update(id, obj);
    }
}
