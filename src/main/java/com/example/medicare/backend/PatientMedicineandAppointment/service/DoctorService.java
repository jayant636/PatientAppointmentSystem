package com.example.medicare.backend.PatientMedicineandAppointment.service;


import com.example.medicare.backend.PatientMedicineandAppointment.dtos.DoctorDto;
import com.example.medicare.backend.PatientMedicineandAppointment.entity.DoctorEntity;
import com.example.medicare.backend.PatientMedicineandAppointment.exceptions.ResourceNotFoundException;
import com.example.medicare.backend.PatientMedicineandAppointment.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    public DoctorDto createNewDoctor(DoctorDto doctorDto) {
        DoctorEntity doctorEntity = modelMapper.map(doctorDto, DoctorEntity.class);
        DoctorEntity saveNewDoctor = doctorRepository.save(doctorEntity);
        return modelMapper.map(saveNewDoctor, DoctorDto.class);
    }

    public List<DoctorDto> getAllDoctors() {
        List<DoctorEntity> getAllDoctor = doctorRepository.findAll();
        return getAllDoctor.stream().map(doctorEntity -> modelMapper.map(doctorEntity, DoctorDto.class)).collect(Collectors.toList());
    }

    public Optional<DoctorDto> getDoctorById(Long doctorId) {
        Optional<DoctorEntity>  doctorEntity = doctorRepository.findById(doctorId);
        return doctorEntity.map(doctorEntity1 -> modelMapper.map(doctorEntity1, DoctorDto.class));
    }

    public DoctorDto updateDoctor(Long doctorId, DoctorDto doctorDto) {

        boolean checkUser = doctorRepository.existsById(doctorId);
        if(!checkUser) throw new ResourceNotFoundException("Doctor does not exists");

        DoctorEntity doctorEntity = modelMapper.map(doctorDto, DoctorEntity.class);
        doctorEntity.setDoctorId(doctorId);
        DoctorEntity updateDoctor = doctorRepository.save(doctorEntity);
        return modelMapper.map(updateDoctor, DoctorDto.class);
    }
}
