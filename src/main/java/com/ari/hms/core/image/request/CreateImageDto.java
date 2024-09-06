package com.ari.hms.core.image.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateImageDto {

    @NotBlank
    private String name;

    @NotBlank
    private String fileType;

    private MultipartFile file;

    private Long userId;
}