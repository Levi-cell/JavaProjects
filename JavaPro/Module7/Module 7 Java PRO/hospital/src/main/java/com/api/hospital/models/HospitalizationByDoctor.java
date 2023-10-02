package com.api.hospital.models;

import java.util.List;

public class HospitalizationByDoctor {
    private Doctor doctor;
    private List<Hospitalization> hospitalizations;

    public HospitalizationByDoctor(Doctor doctor, List<Hospitalization> hospitalizations) {
        this.doctor = doctor;
        this.hospitalizations = hospitalizations;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Hospitalization> getHospitalizations() {
        return hospitalizations;
    }

    public void setHospitalizations(List<Hospitalization> hospitalizations) {
        this.hospitalizations = hospitalizations;
    }
}
