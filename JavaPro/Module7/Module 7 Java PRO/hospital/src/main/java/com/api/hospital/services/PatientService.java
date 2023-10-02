package com.api.hospital.services;

import com.api.hospital.models.Patient;
import com.api.hospital.repository.RepositoryPatient;
import com.api.hospital.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private RepositoryPatient repositoryPatient;

    public List<Patient> findAll(){
        return repositoryPatient.findAll();
    }

    public Patient findById(Long id){
        Optional<Patient> obj = repositoryPatient.findById(id);
        return obj.orElseThrow(()-> new NotFoundException("Id não encontrado"));
    }

    public Patient post(Patient patient){
        return repositoryPatient.save(patient);
    }

    public Patient update(Patient patient){
        return repositoryPatient.save(patient);
    }

    public void delete(Long id){
        repositoryPatient.deleteById(id);
    }
}
