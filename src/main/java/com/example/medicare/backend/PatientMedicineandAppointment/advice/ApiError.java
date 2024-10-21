package com.example.medicare.backend.PatientMedicineandAppointment.advice;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
public class ApiError {
    private String message;
    private HttpStatus status;
}
