package com.api.hospital.repository;

import com.api.hospital.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDoctor extends JpaRepository<Doctor, Long> {
}
