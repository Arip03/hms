package com.ari.hms.core.patient.patientHistory;

import com.ari.hms.core.patient.patientHistory.dto.response.PatientHistoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatientHistoryMapper {

    PatientHistoryDTO patientHistoryToPatientHistoryDTO(PatientHistory patientHistory);
}