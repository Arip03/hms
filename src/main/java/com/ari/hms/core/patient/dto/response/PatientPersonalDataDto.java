package com.ari.hms.core.patient.dto.response;

import com.ari.hms.core.patient.enumerated.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientPersonalDataDto {

    private String firstName;
    private String lastName;
    private String personalNumber;
    private Gender gender;
    private Date dateOfBirth;
}
