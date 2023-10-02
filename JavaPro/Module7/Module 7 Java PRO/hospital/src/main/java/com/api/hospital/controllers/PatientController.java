package com.api.hospital.controllers;

import com.api.hospital.models.Patient;
import com.api.hospital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nursery/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> findAll(){
        return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById (@PathVariable("id") Long id){
        patientService.findById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Patient> post(Patient patient){
       return new ResponseEntity<>( patientService.post(patient), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Patient> update (Patient patient){
        return new ResponseEntity<>(patientService.update(patient), HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id){
        patientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
