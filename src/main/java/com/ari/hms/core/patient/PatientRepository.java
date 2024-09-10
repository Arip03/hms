package com.ari.hms.core.patient;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    boolean existsPatientByPersonalNumber(String personalNumber);
}