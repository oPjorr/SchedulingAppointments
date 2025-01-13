package com.example.SchedulingAppointmentsSpring.controllers;

import com.example.SchedulingAppointmentsSpring.entities.DTO.PacientDTO;
import com.example.SchedulingAppointmentsSpring.services.PacientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pacients")
public class PacientController {

    @Autowired
    PacientService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PacientDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PacientDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public PacientDTO insert(@Valid @RequestBody PacientDTO obj) {
        return service.insert(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deletado com sucelson!");
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PacientDTO update(@PathVariable UUID id, @Valid @RequestBody PacientDTO obj) {
        return service.update(id, obj);
    }
}
