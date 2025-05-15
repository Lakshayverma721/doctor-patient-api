package com.example.doctorpatient.model;

public enum Symptom {
    ARTHRITIS(Speciality.ORTHOPAEDIC),
    BACK_PAIN(Speciality.ORTHOPAEDIC),
    TISSUE_INJURIES(Speciality.ORTHOPAEDIC),
    DYSMENORRHEA(Speciality.GYNECOLOGY),
    SKIN_INFECTION(Speciality.DERMATOLOGY),
    SKIN_BURN(Speciality.DERMATOLOGY),
    EAR_PAIN(Speciality.ENT);

    private final Speciality speciality;

    Symptom(Speciality speciality) {
        this.speciality = speciality;
    }

    public Speciality getSpeciality() {
        return speciality;
    }
}