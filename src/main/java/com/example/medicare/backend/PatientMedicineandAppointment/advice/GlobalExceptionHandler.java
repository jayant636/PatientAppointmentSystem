package com.example.medicare.backend.PatientMedicineandAppointment.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ApiError resourceNotFoundEXception(NoSuchElementException noSuchElementException){
       ApiError apiError = ApiError.builder().message("ResourceNotFound").status(HttpStatus.NOT_FOUND).build();
       return apiError;
    }
}
