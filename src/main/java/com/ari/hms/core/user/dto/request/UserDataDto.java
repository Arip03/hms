package com.ari.hms.core.user.dto.request;

import com.ari.hms.core.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDataDto {

    private String username;

    private Role userRole;
}
