package com.example.SchedulingAppointmentsSpring.services;

import com.example.SchedulingAppointmentsSpring.entities.DTO.DoctorDTO;
import com.example.SchedulingAppointmentsSpring.entities.user.Doctor;
import com.example.SchedulingAppointmentsSpring.entities.user.User;
import com.example.SchedulingAppointmentsSpring.repositories.UserRepository;
import com.example.SchedulingAppointmentsSpring.services.exceptions.DatabaseException;
import com.example.SchedulingAppointmentsSpring.services.exceptions.ResourceNotFoundUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private UserRepository repository;

    public List<DoctorDTO> findAll() {
        List<User> users = repository.findAll();
        return users.stream().filter(user -> user instanceof Doctor).map(user -> (Doctor) user).map(this::toDoctorDTO).collect(Collectors.toList());
    }

    public DoctorDTO findById(UUID id) {
        Optional<User> obj = repository.findById(id);
        Doctor doctor = (Doctor) obj.orElseThrow(() -> new ResourceNotFoundUserException(id));
        return toDoctorDTO(doctor);
    }

    public DoctorDTO insert(DoctorDTO obj) {
        Doctor user = toDoctor(obj);
        repository.save(user);
        return toDoctorDTO(user);
    }

    public void delete(UUID id) {
        try {
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundUserException(id);
            }
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public DoctorDTO update(UUID id, DoctorDTO obj) {
        if (repository.existsById(id)) {
            Doctor entity = (Doctor) repository.getReferenceById(id);
            updateData(entity, obj);
            repository.save(entity);
            return toDoctorDTO(entity);
        }
        throw new ResourceNotFoundUserException(id);
    }

    public void updateData(Doctor entity, DoctorDTO obj) {
        entity.setLogin(obj.login());
        entity.setEmail(obj.email());
        entity.setPhone(obj.phone());
        entity.setRole(obj.role());
        entity.setSpeciallity(obj.speciallity());
        entity.setAcademicDegree(obj.academicDegree());
        entity.setHospital(obj.hospital());
    }

    private DoctorDTO toDoctorDTO(Doctor doctor) {
        return new DoctorDTO(doctor.getLogin(),
                doctor.getPassword(),
                doctor.getEmail(),
                doctor.getPhone(),
                doctor.getRole(),
                doctor.getSpeciallity(),
                doctor.getAcademicDegree(),
                doctor.getHospital());
    }

    private Doctor toDoctor(DoctorDTO doctorDTO) {
        return new Doctor(doctorDTO.login(),
                doctorDTO.password(),
                doctorDTO.email(),
                doctorDTO.phone(),
                doctorDTO.role(),
                doctorDTO.speciallity(),
                doctorDTO.academicDegree(),
                doctorDTO.hospital());
    }
}
