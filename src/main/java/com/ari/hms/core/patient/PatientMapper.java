package com.ari.hms.core.patient;

import com.ari.hms.core.allergy.AllergyMapper;
import com.ari.hms.core.chronicDisease.ChronicDiseaseMapper;
import com.ari.hms.core.patient.dto.request.CreatePatientDto;
import com.ari.hms.core.patient.dto.response.PatientDTO;
import com.ari.hms.core.patient.dto.response.PatientPersonalDataDto;
import com.ari.hms.core.patient.patientHistory.PatientHistoryMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AllergyMapper.class, ChronicDiseaseMapper.class, PatientHistoryMapper.class})
public interface PatientMapper {

    Patient createDtoToPatient(CreatePatientDto createPatientDto);

    CreatePatientDto patientToCreateDto(Patient patient);

    PatientPersonalDataDto patientToPersonalDataDto(Patient patient);

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    @Mapping(source = "allergies", target = "allergies")
    @Mapping(source = "chronicDiseases", target = "chronicDiseases")
    @Mapping(source = "history", target = "history")
    PatientDTO patientToPatientDTO(Patient patient);
}
