package com.ari.hms.core.user;

import com.ari.hms.core.user.dto.request.UserDataDto;
import com.ari.hms.core.user.dto.response.ProfileUserDto;

public interface UserService {

    UserDataDto verifyUser(String token);

    ProfileUserDto getProfileUserById(String token);

}
