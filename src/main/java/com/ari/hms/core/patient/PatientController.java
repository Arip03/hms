package com.ari.hms.core.patient;

import com.ari.hms.core.patient.dto.request.CreatePatientDto;
import com.ari.hms.core.patient.dto.response.CreatePatientResponse;
import com.ari.hms.core.patient.dto.response.PatientDTO;
import com.ari.hms.core.user.User;
import com.ari.hms.core.user.UserRepository;
import com.ari.hms.core.user.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
    public ResponseEntity<CreatePatientResponse> createPatient(@RequestBody @Valid CreatePatientDto createPatientDto) {
        Patient patient = patientMapper.createDtoToPatient(createPatientDto);

        Patient createdPatient = patientService.createPatient(patient);

        CreatePatientResponse response = new CreatePatientResponse(
                createdPatient.getId(),
                "Patient added successfully"
        );

        URI location = URI.create("/patients/" + createdPatient.getId());
       
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{personalNumber}")
    public PatientDTO getPatient(@PathVariable String personalNumber) {
       Patient patient = patientService.getPatientByPersonalNumber(personalNumber);
       return patientMapper.patientToPatientDTO(patient);
    }
}
