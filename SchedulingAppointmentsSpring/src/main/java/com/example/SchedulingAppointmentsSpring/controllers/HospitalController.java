package com.example.SchedulingAppointmentsSpring.controllers;

import com.example.SchedulingAppointmentsSpring.entities.DTO.HospitalDTO;
import com.example.SchedulingAppointmentsSpring.services.HospitalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {
    @Autowired
    HospitalService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HospitalDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HospitalDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public HospitalDTO insert(@Valid @RequestBody HospitalDTO obj) {
        return service.insert(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deletado com sucesso!");
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HospitalDTO update(@PathVariable Long id, @Valid @RequestBody HospitalDTO obj) {
        return service.update(id, obj);
    }
}
