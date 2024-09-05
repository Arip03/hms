package com.ari.hms.core.user;

import com.ari.hms.core.user.dto.request.UserDataDto;

public interface UserService {

    UserDataDto verifyUser(String token);

}
