package com.example.SchedulingAppointmentsSpring.services;

import com.example.SchedulingAppointmentsSpring.entities.DTO.AppointmentDTO;
import com.example.SchedulingAppointmentsSpring.entities.Appointment;
import com.example.SchedulingAppointmentsSpring.repositories.AppointmentRepository;
import com.example.SchedulingAppointmentsSpring.services.exceptions.DatabaseException;
import com.example.SchedulingAppointmentsSpring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository repository;

    public List<AppointmentDTO> findAll() {
        List<Appointment> appointments = repository.findAll();
        return appointments.stream().map(this::toAppointmentDTO).collect(Collectors.toList());
    }

    public AppointmentDTO findById(Long id) {
        Optional<Appointment> obj = repository.findById(id);
        Appointment appointment = obj.orElseThrow(() -> new ResourceNotFoundException(id));
        return toAppointmentDTO(appointment);
    }

    public AppointmentDTO insert(AppointmentDTO obj) {
        Appointment appointment = toAppointment(obj);
        repository.save(appointment);
        return toAppointmentDTO(appointment);
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

    public AppointmentDTO update(Long id, AppointmentDTO obj) {
        if (repository.existsById(id)) {
            Appointment entity = repository.getReferenceById(id);
            updateData(entity, obj);
            repository.save(entity);
            return toAppointmentDTO(entity);
        }
        throw new ResourceNotFoundException(id);
    }

    public void updateData(Appointment entity, AppointmentDTO obj) {
        entity.setCause(obj.cause());
        entity.setDescription(obj.description());
        entity.setDoctor(obj.doctor());
        entity.setDateStart(obj.dateStart());
        entity.setDateEnd(obj.dateEnd());
        entity.setStatus(obj.status());
        entity.setPacient(obj.pacient());
    }

    private AppointmentDTO toAppointmentDTO(Appointment appointment) {
        return new AppointmentDTO(appointment.getId(), appointment.getCause(), appointment.getDescription(), appointment.getDoctor(), appointment.getDateStart(), appointment.getDateEnd(), appointment.getStatus(), appointment.getPacient());
    }

    private Appointment toAppointment(AppointmentDTO appointmentDTO) {
        return new Appointment(appointmentDTO.id(), appointmentDTO.cause(), appointmentDTO.description(), appointmentDTO.dateStart(), appointmentDTO.dateEnd(), appointmentDTO.doctor(), appointmentDTO.pacient(), appointmentDTO.status());
    }
}
