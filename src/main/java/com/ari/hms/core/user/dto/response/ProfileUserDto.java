package com.ari.hms.core.user.dto.response;

import com.ari.hms.core.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUserDto {

    private String fullName;

    private String username;

    private Role role;
}
