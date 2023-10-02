package com.api.hospital.repository;

import com.api.hospital.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPatient extends JpaRepository<Patient,Long> {
}
