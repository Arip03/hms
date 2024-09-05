package com.ari.hms.core.auth;

import com.ari.hms.core.auth.dto.request.LoginRequestDto;
import com.ari.hms.core.auth.dto.response.AuthenticationResponse;
import com.ari.hms.core.user.dto.request.CreateUserDto;
import org.springframework.security.core.AuthenticationException;

public interface AuthService {

    AuthenticationResponse authenticate(LoginRequestDto request)throws AuthenticationException;

    AuthenticationResponse create(CreateUserDto createUser);
}
