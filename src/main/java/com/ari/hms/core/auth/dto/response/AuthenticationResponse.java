package com.ari.hms.core.auth.dto.response;

import com.ari.hms.core.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationResponse {

    private String token;

    private Role role;
}