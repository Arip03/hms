package com.ari.hms.core.user.dto.request;

import com.ari.hms.config.unique_username.UniqueUsername;
import com.ari.hms.core.user.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserDto {

    @NotBlank(message = "Name is required")
    private String firstname;

    @NotBlank(message = "Last name is required")
    private String lastname;

    @UniqueUsername(message = "This username exists!")
    @NotBlank(message = "Username is required")
    private String username;

    @Email(message = "Must be of type email")
    @NotBlank(message = "Email is required")
    private String email;

    @Size(min = 3, max = 10, message = "Password must be between 3 and 10 characters ")
    private String password;

    @NotNull
    private Role role;
}
