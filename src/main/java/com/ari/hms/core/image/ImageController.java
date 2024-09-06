package com.ari.hms.core.image;

import com.ari.hms.config.security.services.jwt.JwtService;
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

    private final JwtService jwtService;

    public ImageController(ImageService imageService, JwtService jwtService) {
        this.imageService = imageService;
        this.jwtService = jwtService;
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

    @GetMapping
    public ResponseEntity<ImageResponse> getUserImageAsBase64(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.replace("Bearer ", "");
        ImageResponse base64Image = imageService.getImageAsBase64(jwtService.extractUsername(token));
        return ResponseEntity.ok(base64Image);
    }
}
