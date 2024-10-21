package com.example.medicare.backend.PatientMedicineandAppointment.service;

import com.example.medicare.backend.PatientMedicineandAppointment.dtos.PatientDto;
import com.example.medicare.backend.PatientMedicineandAppointment.entity.PatientEntity;
import com.example.medicare.backend.PatientMedicineandAppointment.exceptions.ResourceNotFoundException;
import com.example.medicare.backend.PatientMedicineandAppointment.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    public PatientDto createNewPatient(PatientDto patientDto) {
        //Convert dto to entity
        //save the entity in table
        //convert savedEntity into dto
        PatientEntity patientEntity = modelMapper.map(patientDto,PatientEntity.class);
        PatientEntity newPatient = patientRepository.save(patientEntity);
        return modelMapper.map(newPatient,PatientDto.class);
    }

    public List<PatientDto> getAllPatient() {
        //fetch all the patients
        //use stream & map function to return the list of all employees
        List<PatientEntity> patientEntity = patientRepository.findAll();
        return patientEntity.stream()
                .map(patientEntity1 -> modelMapper.map(patientEntity1,PatientDto.class))
                .collect(Collectors.toList());
    }

    public Optional<PatientDto> getPatientById(Long patientId) {
        Optional<PatientEntity> patientEntity = patientRepository.findById(patientId);
        return patientEntity.map(patientEntity1 -> modelMapper.map(patientEntity1, PatientDto.class));
    }

    public PatientDto updatePatientDetails(Long patientId, PatientDto patientDto) {
        //check user exists
        //if yes follow creation steps
        boolean userExists = patientRepository.existsById(patientId);
        if(!userExists){
            throw  new ResourceNotFoundException("Patiend not found with id:"+patientId);
        }

        PatientEntity patientEntity = modelMapper.map(patientDto,PatientEntity.class);
        PatientEntity savedPatient = patientRepository.save(patientEntity);
        return modelMapper.map(savedPatient, PatientDto.class);

    }

    public PatientDto patchPatientDetails(Map<String, Object> updates, Long patientId) {

        boolean patientExist = patientRepository.existsById(patientId);
        if(!patientExist) return null;

        PatientEntity patientEntity = patientRepository.findById(patientId).get();

        updates.forEach((field,value)->{
            Field fieldToBeUpdated = ReflectionUtils.findField(PatientEntity.class,field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,patientEntity,value);
        });
        PatientEntity updatedPatientsField = patientRepository.save(patientEntity);
        return modelMapper.map(updatedPatientsField,PatientDto.class);
    }

}
