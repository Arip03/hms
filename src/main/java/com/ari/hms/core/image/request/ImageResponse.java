package com.ari.hms.core.image.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ImageResponse {

    private String fileName;
    private String fileType;
    private String base64Content;
}
