package com.ari.hms.core.patient.dto.response;

import com.ari.hms.core.allergy.dto.response.AllergyDTO;
import com.ari.hms.core.chronicDisease.dto.response.ChronicDiseaseDTO;
import com.ari.hms.core.patient.enumerated.Gender;
import com.ari.hms.core.patient.patientHistory.dto.response.PatientHistoryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    private UUID id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String personalNumber;
    private Gender gender;
    private Date dateOfBirth;
    private String address;
    private String phone;
    private String email;
    private List<AllergyDTO> allergies;
    private List<ChronicDiseaseDTO> chronicDiseases;
    private List<PatientHistoryDTO> history;
}
