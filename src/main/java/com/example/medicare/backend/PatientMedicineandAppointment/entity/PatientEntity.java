package com.example.medicare.backend.PatientMedicineandAppointment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String patientName;

    private String email;
    private String password;
    private Long govtIdProof;
    private Long age;
    private Long contactNo;
    private String disease;
}
