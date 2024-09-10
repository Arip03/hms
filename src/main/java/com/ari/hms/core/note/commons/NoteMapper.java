package com.ari.hms.core.note.commons;

import com.ari.hms.core.user.User;
import com.ari.hms.core.user.dto.request.CreateUserDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface NoteMapper {

    User map(CreateUserDto source);
}
