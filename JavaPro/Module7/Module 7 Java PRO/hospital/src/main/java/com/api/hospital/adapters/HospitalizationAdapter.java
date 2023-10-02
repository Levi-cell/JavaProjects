package com.api.hospital.adapters;

import com.api.hospital.models.*;

import java.util.List;
import java.util.stream.Collectors;

public class HospitalizationAdapter {
    public List<HospitalizationByPatient> adapterHospitalizationByPatient(List<Hospitalization> hospitalizations, List<Patient> patient){
        List<HospitalizationByPatient> hospitalizationByPatients = patient.stream().map(patient1 -> {
            List<Hospitalization> hospitalizationList = hospitalizations.stream().filter(f->f.getPatient().getId().equals(patient1.getId()))
                    .collect(Collectors.toList());
            return new HospitalizationByPatient(patient1,hospitalizationList);
                            }).collect(Collectors.toList());
        return hospitalizationByPatients;
    }

    public List<HospitalizationByDoctor> adapterHospitalizationByDoctor(List<Hospitalization> hospitalizations, List<Doctor> doctors){
        List<HospitalizationByDoctor> hospitalizationByDoctors = doctors.stream().map(doctor ->{
            List<Hospitalization> hospitalizationList = hospitalizations.stream().filter(d->d.getPatient().getId().equals(doctor.getId()))
                    .collect(Collectors.toList());
            return new HospitalizationByDoctor(doctor,hospitalizationList);
        }).collect(Collectors.toList());
        return hospitalizationByDoctors;
    }
}
