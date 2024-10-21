package com.example.medicare.backend.PatientMedicineandAppointment.repository;

import com.example.medicare.backend.PatientMedicineandAppointment.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity,Long> {
}
