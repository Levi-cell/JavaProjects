package com.api.hospital.repository;

import com.api.hospital.models.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryHospitalization extends JpaRepository<Hospitalization,Long> {
}
