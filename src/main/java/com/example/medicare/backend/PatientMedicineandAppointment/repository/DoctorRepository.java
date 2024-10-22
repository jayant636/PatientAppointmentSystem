package com.example.medicare.backend.PatientMedicineandAppointment.repository;

import com.example.medicare.backend.PatientMedicineandAppointment.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity,Long> {
}
