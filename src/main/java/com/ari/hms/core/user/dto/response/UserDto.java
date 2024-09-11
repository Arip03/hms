package com.ari.hms.core.user.dto.response;

import com.ari.hms.core.user.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String fullName;

    private String username;

    private Role role;
}
