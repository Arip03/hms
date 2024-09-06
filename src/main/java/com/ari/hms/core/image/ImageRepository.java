package com.ari.hms.core.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query("Select i from Image i Where i.user.id = :userId")
    Optional<Image> findUserId(@Param("userId") Long userId);
}
