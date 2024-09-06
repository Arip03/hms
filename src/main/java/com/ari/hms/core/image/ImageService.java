package com.ari.hms.core.image;

import com.ari.hms.core.image.request.CreateImageDto;
import com.ari.hms.core.image.request.ImageResponse;

public interface ImageService {

    Image createImage(CreateImageDto createImageDto);

    ImageResponse getImageAsBase64(Long userId);
}
