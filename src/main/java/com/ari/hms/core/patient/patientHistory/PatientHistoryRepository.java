package com.ari.hms.core.patient.patientHistory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientHistoryRepository extends JpaRepository<PatientHistory, UUID> {
}