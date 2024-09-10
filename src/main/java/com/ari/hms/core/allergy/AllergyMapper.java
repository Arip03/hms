package com.ari.hms.core.allergy;

import com.ari.hms.core.allergy.dto.response.AllergyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AllergyMapper {
    AllergyMapper INSTANCE = Mappers.getMapper(AllergyMapper.class);

    AllergyDTO allergyToAllergyDTO(Allergy allergy);
}
