package com.example.doctorpatient.controller;

import com.example.doctorpatient.model.*;
import com.example.doctorpatient.repository.*;
import com.example.doctorpatient.service.SuggestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorPatientController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SuggestionService suggestionService;

    @PostMapping("/doctors")
    public Doctor addDoctor(@Valid @RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @PostMapping("/patients")
    public Patient addPatient(@Valid @RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/suggest-doctors/{patientId}")
    public ResponseEntity<?> suggestDoctors(@PathVariable Long patientId) {
        Object result = suggestionService.suggestDoctors(patientId);
        return ResponseEntity.ok(result);
    }
}