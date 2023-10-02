package com.api.hospital.controllers;

import com.api.hospital.adapters.HospitalizationAdapter;
import com.api.hospital.models.*;
import com.api.hospital.services.DoctorService;
import com.api.hospital.services.HospitalizationService;
import com.api.hospital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nursery/hospitalization")
public class HospitalizationController {
    @Autowired
    private HospitalizationService hospitalizationService;
    @Autowired
    private PatientService patient;
    @Autowired
    private DoctorService doctorService;

    HospitalizationAdapter hospitalizationAdapter = new HospitalizationAdapter();

    @GetMapping
    public ResponseEntity<List<Hospitalization> > findAll(){
        return new ResponseEntity<>(hospitalizationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/by-patient")
    public ResponseEntity<List<HospitalizationByPatient>> hospitalizationByPatient(){
        List<Patient> patients = patient.findAll();
        List<Hospitalization> hospitalizations = hospitalizationService.findAll();

        List<HospitalizationByPatient> hospitalizationByPatients = hospitalizationAdapter
                .adapterHospitalizationByPatient(hospitalizations,patients);

        return new ResponseEntity<>(hospitalizationByPatients, HttpStatus.OK);
    }

    @GetMapping("/by-doctor")
    public ResponseEntity<List<HospitalizationByDoctor>> hospitalizationByDoctor(){
        List<Doctor> doctors = doctorService.findAll();
        List<Hospitalization> hospitalizationList = hospitalizationService.findAll();

        List<HospitalizationByDoctor> hospitalizationByDoctors = hospitalizationAdapter
                .adapterHospitalizationByDoctor(hospitalizationList,doctors);
        return new ResponseEntity<>(hospitalizationByDoctors,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospitalization> findById(@PathVariable("id") Long id){
        hospitalizationService.findById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Hospitalization> post(Hospitalization hospitalization){
        return new ResponseEntity<>(hospitalizationService.post(hospitalization), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Hospitalization> update(Hospitalization hospitalization){
        return new ResponseEntity<>(hospitalizationService.update(hospitalization),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        hospitalizationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
