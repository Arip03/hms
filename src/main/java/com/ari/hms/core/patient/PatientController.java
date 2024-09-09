package com.ari.hms.core.patient;

import com.ari.hms.core.patient.dto.request.CreatePatientDto;
import com.ari.hms.core.user.User;
import com.ari.hms.core.user.UserRepository;
import com.ari.hms.core.user.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    private final PatientMapper patientMapper;

    private final UserRepository userRepository;

    @Autowired
    public PatientController(PatientService patientService, PatientMapper patientMapper, UserRepository userRepository) {
        this.patientService = patientService;
        this.patientMapper = patientMapper;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<?> createPatient(@RequestHeader("Authorization") String authorizationHeader,
                                           @RequestBody @Valid CreatePatientDto createPatientDto) throws BadRequestException {
        Patient patient = patientMapper.createDtoToPatient(createPatientDto);
        try {
            patientService.createPatient(patient, null);
            return ResponseEntity.ok("Patient added successfully");
        } catch (Exception e) {
            throw new BadRequestException("Something went wrong: " + e.getMessage());
        }
    }

}
