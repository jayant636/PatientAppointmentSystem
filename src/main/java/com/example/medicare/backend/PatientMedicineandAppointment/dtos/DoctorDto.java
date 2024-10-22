package com.example.medicare.backend.PatientMedicineandAppointment.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {

    private Long doctorId;
    private String name;
    private String email;
    private String password;
    private String degree;
    private String specialisedIn;
    private Integer experience;
    private Integer age;
    private Long fees;
    private Boolean available;

}
