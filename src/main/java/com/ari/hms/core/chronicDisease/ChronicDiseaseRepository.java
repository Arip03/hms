package com.ari.hms.core.chronicDisease;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChronicDiseaseRepository extends JpaRepository<ChronicDisease, UUID> {
}