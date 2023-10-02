package com.api.hospital.services;

import com.api.hospital.models.Doctor;
import com.api.hospital.repository.RepositoryDoctor;
import com.api.hospital.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private RepositoryDoctor repositoryDoctor;


    public List<Doctor> findAll (){
      return repositoryDoctor.findAll();
    }


    public Doctor findById(Long id){
        Optional<Doctor> obj = repositoryDoctor.findById(id);
        return obj.orElseThrow(()-> new NotFoundException("Id Não encontrado"));
    }
    public Doctor post(Doctor doctor){
        return repositoryDoctor.save(doctor);
    }

    public Doctor update(Doctor doctor){
        return repositoryDoctor.save(doctor);
    }

    public void delete(Long id){
        repositoryDoctor.deleteById(id);
    }


}
