package com.example.SchedulingAppointmentsSpring.services;

import com.example.SchedulingAppointmentsSpring.entities.DTO.HospitalDTO;
import com.example.SchedulingAppointmentsSpring.entities.Hospital;
import com.example.SchedulingAppointmentsSpring.repositories.HospitalRepository;
import com.example.SchedulingAppointmentsSpring.services.exceptions.DatabaseException;
import com.example.SchedulingAppointmentsSpring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository repository;

    public List<HospitalDTO> findAll() {
        List<Hospital> hospitals = repository.findAll();
        return hospitals.stream().map(this::toHospitalDTO).collect(Collectors.toList());
    }

    public HospitalDTO findById(Long id) {
        Optional<Hospital> obj = repository.findById(id);
        Hospital hospital = obj.orElseThrow(() -> new ResourceNotFoundException(id));
        return toHospitalDTO(hospital);
    }

    public HospitalDTO insert(HospitalDTO obj) {
        Hospital hospital = toHospital(obj);
        repository.save(hospital);
        return toHospitalDTO(hospital);
    }

    public void delete(Long id) {
        try {
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            }
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public HospitalDTO update(Long id, HospitalDTO obj) {
        if (repository.existsById(id)) {
            Hospital entity = repository.getReferenceById(id);
            updateData(entity, obj);
            repository.save(entity);
            return toHospitalDTO(entity);
        }
        throw new ResourceNotFoundException(id);
    }

    public void updateData(Hospital entity, HospitalDTO obj) {
        entity.setName(obj.name());
        entity.setCep(obj.cep());
        entity.setAddress(obj.address());
    }

    private HospitalDTO toHospitalDTO(Hospital hospital) {
        return new HospitalDTO(hospital.getId(), hospital.getName(), hospital.getCep(), hospital.getAddress(), hospital.getDoctors());
    }

    private Hospital toHospital(HospitalDTO hospitalDTO) {
        return new Hospital(hospitalDTO.id(), hospitalDTO.name(), hospitalDTO.cep(), hospitalDTO.address(), hospitalDTO.doctors());
    }
}
