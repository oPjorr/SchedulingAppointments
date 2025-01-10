package com.example.SchedulingAppointmentsSpring.controllers;

import com.example.SchedulingAppointmentsSpring.entities.DTO.DoctorDTO;
import com.example.SchedulingAppointmentsSpring.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    DoctorService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DoctorDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public DoctorDTO insert(@Valid @RequestBody DoctorDTO obj) {
        return service.insert(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deletado com sucelson!");
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorDTO update(@PathVariable UUID id, @Valid @RequestBody DoctorDTO obj) {
        return service.update(id, obj);
    }

}
