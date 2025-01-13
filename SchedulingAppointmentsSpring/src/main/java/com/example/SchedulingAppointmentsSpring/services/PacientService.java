package com.example.SchedulingAppointmentsSpring.services;

import com.example.SchedulingAppointmentsSpring.entities.DTO.PacientDTO;
import com.example.SchedulingAppointmentsSpring.entities.user.Pacient;
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
public class PacientService {


    @Autowired
    private UserRepository repository;

    public List<PacientDTO> findAll() {
        List<User> users = repository.findAll();
        return users.stream().filter(user -> user instanceof Pacient).map(user -> (Pacient) user).map(this::toPacientDTO).collect(Collectors.toList());
    }

    public PacientDTO findById(UUID id) {
        Optional<User> obj = repository.findById(id);
        Pacient pacient = (Pacient) obj.orElseThrow(() -> new ResourceNotFoundUserException(id));
        return toPacientDTO(pacient);
    }

    public PacientDTO insert(PacientDTO obj) {
        Pacient user = toPacient(obj);
        repository.save(user);
        return toPacientDTO(user);
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

    public PacientDTO update(UUID id, PacientDTO obj) {
        if (repository.existsById(id)) {
            Pacient entity = (Pacient) repository.getReferenceById(id);
            updateData(entity, obj);
            repository.save(entity);
            return toPacientDTO(entity);
        }
        throw new ResourceNotFoundUserException(id);
    }

    public void updateData(Pacient entity, PacientDTO obj) {
        entity.setLogin(obj.login());
        entity.setEmail(obj.email());
        entity.setPhone(obj.phone());
        entity.setRole(obj.role());
        entity.setAllergy(obj.allergy());
        entity.setAllergyType(obj.allergyType());
    }

    private PacientDTO toPacientDTO(Pacient pacient) {
        return new PacientDTO(pacient.getLogin(),
                pacient.getPassword(),
                pacient.getEmail(),
                pacient.getPhone(),
                pacient.getRole(),
                pacient.getAge(),
                pacient.getAddress(),
                pacient.getHeight(),
                pacient.isAllergy(),
                pacient.getAllergyType());
    }

    private Pacient toPacient(PacientDTO pacientDTO) {
        return new Pacient(pacientDTO.login(),
                pacientDTO.password(),
                pacientDTO.email(),
                pacientDTO.phone(),
                pacientDTO.role(),
                pacientDTO.age(),
                pacientDTO.address(),
                pacientDTO.height(),
                pacientDTO.allergy(),
                pacientDTO.allergyType());
    }
}