package com.api.hospital.services;

import com.api.hospital.models.Hospitalization;
import com.api.hospital.repository.RepositoryHospitalization;
import com.api.hospital.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalizationService {

    @Autowired
    private RepositoryHospitalization repositoryHospitalization;

    public List<Hospitalization> findAll(){
        return repositoryHospitalization.findAll();
    }

    public Hospitalization findById(Long id){
        Optional<Hospitalization> obj = repositoryHospitalization.findById(id);
        return obj.orElseThrow(()-> new NotFoundException("Id não encontrado"));
    }

    public Hospitalization post(Hospitalization hospitalization){
        return repositoryHospitalization.save(hospitalization);
    }
    public Hospitalization update (Hospitalization hospitalization){
        return repositoryHospitalization.save(hospitalization);
    }

    public void delete(Long id){
        repositoryHospitalization.deleteById(id);
    }
}
