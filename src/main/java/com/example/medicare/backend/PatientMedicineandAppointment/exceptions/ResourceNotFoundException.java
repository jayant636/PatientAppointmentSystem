package com.example.medicare.backend.PatientMedicineandAppointment.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
