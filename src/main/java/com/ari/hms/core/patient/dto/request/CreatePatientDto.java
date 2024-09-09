package com.ari.hms.core.patient.dto.request;

import com.ari.hms.core.patient.enumerated.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientDto {

    @NonNull
    @NotEmpty
    private String firstName;

    @NonNull
    @NotEmpty
    private String fatherName;

    @NonNull
    @NotEmpty
    private String lastName;

    @NonNull
    @NotEmpty
    private String personalNumber;

    @NonNull
    private Gender gender;

    @NonNull
    private Date dateOfBirth;

    @NonNull
    @NotEmpty
    private String address;

    @NonNull
    @NotEmpty
    private String phone;

    @NonNull
    @NotEmpty
    @Email
    private String email;

    private String maritalStatus;

    private String occupation;

    private String insuranceNumber;
}
