package com.ari.hms.core.user.commons;

import com.ari.hms.core.user.User;
import com.ari.hms.core.user.dto.request.CreateUserDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

//    @Mapping(target = "password",
//            expression = "java(source.getPassword() != null ? encode(source.getPassword()) : null)")
    User map(CreateUserDto source);

//    @Mapping(source = "role.roleName", target = "role")
//    @Mapping(target = "email", expression = "java(source.getEmail())")
//    @Mapping(target = "firstname", expression = "java(source.getFirstname())")
//    @Mapping(target = "lastname", expression = "java(source.getLastname())")
//    ViewUser map(User source);

//    @Mapping(target = "firstname",
//            expression = "java(source.getFirstname() != null ? source.getFirstname() : target.getFirstname())")
//    @Mapping(target = "lastname",
//            expression = "java(source.getLastname() != null ? source.getLastname() : target.getLastname())")
//    @Mapping(target = "email",
//            expression = "java(source.getEmail() != null ? source.getEmail() : target.getEmail())")
//    @Mapping(target = "password",
//            expression = "java(source.getPassword() != null ? encode(source.getPassword()) : target.getPassword())")
//    @Mapping(source = "role", target = "role.roleName")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void mapDtoToEntity(UpdateUser source, @MappingTarget User target);

//    @Mapping(target = "firstname",
//            expression = "java(source.getFirstname() != null ? source.getFirstname() : target.getFirstname())")
//    @Mapping(target = "lastname",
//            expression = "java(source.getLastname() != null ? source.getLastname() : target.getLastname())")
//    @Mapping(target = "email",
//            expression = "java(source.getEmail() != null ? source.getEmail() : target.getEmail())")
//    @Mapping(target = "password",
//            expression = "java(source.getPassword() != null ? encode(source.getPassword()) : target.getPassword())")
//    @Mapping(source = "role.roleName", target = "role")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void mapEntityToDto(User source, @MappingTarget UpdateUser target);

//    default String encode(String password) {
//        if (password == null) {
//            return null;
//        }
//        return passwordEncoder.encode(password);
//    }
}
