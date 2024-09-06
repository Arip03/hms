package com.ari.hms.core.image.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateImageDto {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String fileType;

    @NotNull
    private long size;

    @NotBlank
    private String fileUrl;

    private Long userId;
}
