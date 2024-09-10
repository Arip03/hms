package com.ari.hms.core.allergy.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllergyDTO {

    private UUID id;
    private String allergen;
    private String reaction;
    private String severity;
}