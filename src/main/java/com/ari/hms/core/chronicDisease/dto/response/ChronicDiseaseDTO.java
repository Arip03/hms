package com.ari.hms.core.chronicDisease.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChronicDiseaseDTO {

    private UUID id;
    private String diseaseName;
    private String symptoms;
    private String treatment;
}
