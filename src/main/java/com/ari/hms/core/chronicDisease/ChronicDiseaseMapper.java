package com.ari.hms.core.chronicDisease;

import com.ari.hms.core.chronicDisease.dto.response.ChronicDiseaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChronicDiseaseMapper {
    ChronicDiseaseMapper INSTANCE = Mappers.getMapper(ChronicDiseaseMapper.class);

    ChronicDiseaseDTO chronicDiseaseToChronicDiseaseDTO(ChronicDisease chronicDisease);
}