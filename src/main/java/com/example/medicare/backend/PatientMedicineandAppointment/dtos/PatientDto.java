package com.example.medicare.backend.PatientMedicineandAppointment.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private Long patientId;
    private String patientName;
    private String email;
    private String password;
    private Long govtIdProof;
    private Long age;
    private Long contactNo;
    private String disease;

}
