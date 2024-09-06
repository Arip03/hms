package com.ari.hms.core.image;

import com.ari.hms.core.commons.exception.BadRequestException;
import com.ari.hms.core.image.request.CreateImageDto;
import com.ari.hms.core.image.request.ImageResponse;
import com.ari.hms.core.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class ImageServiceImpl implements ImageService{

    private final Path fileStorageLocation = Paths.get("../resources/uploaded-images");
    private final ImageRepository imageRepository;
    private final UserRepository userRepository;

    public ImageServiceImpl(ImageRepository imageRepository,
                            UserRepository userRepository) {
        this.imageRepository = imageRepository;
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory to upload images.", ex);
        }
        this.userRepository = userRepository;
    }

    public Image createImage(CreateImageDto createImageDto) {
        MultipartFile file = createImageDto.getFile();
        String fileName = createImageDto.getName();

        try {
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation);

            Image image = new Image();
            image.setName(fileName);
            image.setFileType(createImageDto.getFileType());
            image.setFileUrl(targetLocation.toString());
            image.setUser(userRepository.findById(createImageDto.getUserId()).orElseThrow(
                    () -> new BadRequestException("User not exist")
            ));

            return imageRepository.save(image);

        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public ImageResponse getImageAsBase64(String username) {
        Image image = imageRepository.findUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("Image not found for user " + username));

        try {
            Path imagePath = Paths.get(image.getFileUrl());
            byte[] imageBytes = Files.readAllBytes(imagePath);

            String base64Content = Base64.getEncoder().encodeToString(imageBytes);

            return ImageResponse.builder()
                    .fileName(image.getName())
                    .fileType(image.getFileType())
                    .base64Content(base64Content)
                    .build();

        } catch (IOException ex) {
            throw new RuntimeException("Could not read file " + image.getFileUrl(), ex);
        }
    }
}