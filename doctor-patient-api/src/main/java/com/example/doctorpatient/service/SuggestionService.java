package com.example.doctorpatient.service;

import com.example.doctorpatient.model.*;
import com.example.doctorpatient.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuggestionService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public Object suggestDoctors(Long patientId) {
        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        if (patientOpt.isEmpty()) {
            return "Patient not found";
        }
        Patient patient = patientOpt.get();
        Symptom symptom = patient.getSymptom();
        Speciality speciality = symptom.getSpeciality();

        try {
            City city = City.valueOf(patient.getCity().toUpperCase());
            List<Doctor> doctors = doctorRepository.findByCityAndSpeciality(city, speciality);
            if (doctors.isEmpty()) {
                return "There isn’t any doctor present at your location for your symptom";
            }
            return doctors;
        } catch (IllegalArgumentException e) {
            return "We are still waiting to expand to your location";
        }
    }
}