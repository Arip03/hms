package com.ari.hms.core.user.dto.response;

import lombok.*;

@Data
public class UserDto {
    private Long id;
    private String referenceId;
    private String role;
    private int remainingLeaves;
    private String department;
}
