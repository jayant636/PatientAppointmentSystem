package com.example.medicare.backend.PatientMedicineandAppointment.controllers;

import com.example.medicare.backend.PatientMedicineandAppointment.dtos.DoctorDto;
import com.example.medicare.backend.PatientMedicineandAppointment.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<DoctorDto> createNewDoctor(@RequestBody DoctorDto doctorDto){
        DoctorDto doctorDto1 =  doctorService.createNewDoctor(doctorDto);
        return new ResponseEntity<>(doctorDto1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        List<DoctorDto> listOfDoctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(listOfDoctors);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long doctorId){
       Optional<DoctorDto>  doctorDto = doctorService.getDoctorById(doctorId);
        return doctorDto.map(doctorDto1 -> ResponseEntity.ok(doctorDto1)).orElseThrow(()-> new RuntimeException("Doctor Not Found with id:"+doctorId));
    }

    @PutMapping("/update/{doctorId}")
    public ResponseEntity<DoctorDto> updateDoctor (@PathVariable Long doctorId ,@RequestBody DoctorDto doctorDto){
        DoctorDto doctorDto1 = doctorService.updateDoctor(doctorId,doctorDto);
        return ResponseEntity.ok(doctorDto1);
    }

}
