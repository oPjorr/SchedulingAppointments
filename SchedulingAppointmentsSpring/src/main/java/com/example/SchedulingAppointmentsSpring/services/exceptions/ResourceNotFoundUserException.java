package com.example.SchedulingAppointmentsSpring.services.exceptions;

import java.util.UUID;

public class ResourceNotFoundUserException extends RuntimeException {
    public ResourceNotFoundUserException(UUID id) {
        super("Resource not found. id:  " + id);
    }
}
