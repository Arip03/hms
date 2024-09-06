package com.ari.hms.core.image;

import com.ari.hms.core.image.request.CreateImageDto;
import com.ari.hms.core.image.request.ImageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user/image")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Image> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam Long userId) {
        CreateImageDto createImageDto = CreateImageDto.builder()
                .name(file.getOriginalFilename())
                .fileType(file.getContentType())
                .file(file)
                .userId(userId)
                .build();

        Image createdImage = imageService.createImage(createImageDto);
        return new ResponseEntity<>(createdImage, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ImageResponse> getUserImageAsBase64(@PathVariable Long userId) {
        ImageResponse base64Image = imageService.getImageAsBase64(userId);
        return ResponseEntity.ok(base64Image);
    }
}
