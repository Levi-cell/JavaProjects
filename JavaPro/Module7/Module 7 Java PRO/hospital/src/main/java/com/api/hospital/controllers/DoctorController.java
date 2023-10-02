package com.api.hospital.controllers;

import com.api.hospital.models.Doctor;
import com.api.hospital.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/nursery/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping()
    public ResponseEntity<List<Doctor>> findAll(){
        List<Doctor> all = doctorService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(doctorService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Doctor> post(Doctor doctor){
        return new ResponseEntity<>(doctorService.post(doctor), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Doctor> update (Doctor doctor){
        return new ResponseEntity<>(doctorService.update(doctor), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        doctorService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
