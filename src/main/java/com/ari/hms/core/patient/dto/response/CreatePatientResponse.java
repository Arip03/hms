package com.ari.hms.core.patient.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientResponse {

    private UUID id;

    private String message;
}
