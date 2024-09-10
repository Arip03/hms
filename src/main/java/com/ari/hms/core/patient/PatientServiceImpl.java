package com.ari.hms.core.patient;

import com.ari.hms.config.security.SecurityContext;
import com.ari.hms.core.commons.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(Patient patient) {
        if (!patientRepository.existsPatientByPersonalNumber(patient.getPersonalNumber())) {
            patient.setCreatedBy(SecurityContext.getCurrentUser());

            return patientRepository.save(patient);
        } else {
            throw new BadRequestException("Patient with this personal number already exist");
        }
    }
}
