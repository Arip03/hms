package com.ari.hms.core.patient;

import com.ari.hms.core.patient.dto.request.CreatePatientDto;
import com.ari.hms.core.patient.dto.response.PatientPersonalDataDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient createDtoToPatient(CreatePatientDto createPatientDto);

    CreatePatientDto patientToCreateDto(Patient patient);

    PatientPersonalDataDto patientToPersonalDataDto(Patient patient);
}
