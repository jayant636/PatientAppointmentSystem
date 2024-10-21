package com.example.medicare.backend.PatientMedicineandAppointment.controllers;


import com.example.medicare.backend.PatientMedicineandAppointment.dtos.PatientDto;
import com.example.medicare.backend.PatientMedicineandAppointment.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/{patientId}")
    public Optional<PatientDto>  getPatientById(@PathVariable Long patientId){
        return patientService.getPatientById(patientId);
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> gateAllPatient(){
        return ResponseEntity.ok( patientService.getAllPatient());
    }

    @PostMapping
    public ResponseEntity<PatientDto> createNewPatient(@RequestBody PatientDto patientDto){
        PatientDto patientDto1 = patientService.createNewPatient(patientDto);
        return new ResponseEntity<>(patientDto1, HttpStatus.CREATED);
    }

    @PutMapping("/updatePatient/{patientId}")
    public ResponseEntity<PatientDto>  updatePatientDetails(@PathVariable Long patientId , @RequestBody PatientDto patientDto){
        PatientDto patientDto1 = patientService.updatePatientDetails(patientId,patientDto);
        return ResponseEntity.ok(patientDto1);
    }

    @PatchMapping(path = "/{patientId}")
    public ResponseEntity<PatientDto> patchPatientDetails(@RequestBody Map<String, Object> updates , @PathVariable Long patientId){
        return ResponseEntity.ok(patientService.patchPatientDetails(updates,patientId));
    }

}
