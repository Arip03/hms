package com.ari.hms.core.user;

import com.ari.hms.core.user.dto.request.UserDataDto;
import com.ari.hms.core.user.dto.response.ProfileUserDto;
import com.ari.hms.core.user.dto.response.UserDto;

import java.util.List;

public interface UserService {

    UserDataDto verifyUser(String token);

    ProfileUserDto getProfileUserById(String token);

    List<UserDto> getAllDoctors();

}
