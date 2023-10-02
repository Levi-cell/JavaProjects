package com.api.hospital.models;

import java.util.List;

public class HospitalizationByPatient {
    private Patient patient;
    private List<Hospitalization> hospitalizations;

    public HospitalizationByPatient(Patient patient, List<Hospitalization> hospitalizations) {
        this.patient = patient;
        this.hospitalizations = hospitalizations;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Hospitalization> getHospitalizations() {
        return hospitalizations;
    }

    public void setHospitalizations(List<Hospitalization> hospitalizations) {
        this.hospitalizations = hospitalizations;
    }
}
