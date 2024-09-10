package com.ari.hms.core.patient.patientHistory.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientHistoryDTO {

    private UUID id;
    private Date visitDate;
    private String doctorDescription;
    private String nurseWork;
    private String diagnosis;
    private String treatment;
    private String prescription;
}