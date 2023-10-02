package com.api.hospital.utils;

import com.api.hospital.models.Doctor;
import com.api.hospital.models.Hospitalization;
import com.api.hospital.models.Patient;
import com.api.hospital.repository.RepositoryDoctor;
import com.api.hospital.repository.RepositoryHospitalization;
import com.api.hospital.repository.RepositoryPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
    public class DummyData implements CommandLineRunner {

        @Autowired
        private RepositoryPatient patientsRepository;
        @Autowired
        private RepositoryHospitalization hospitalizationHistoryRepository;
        @Autowired
        private RepositoryDoctor doctorsRepository;

        @Override
        public void run(String... args) throws Exception {
            patientsRepository.deleteAll();
            hospitalizationHistoryRepository.deleteAll();

            // setup pacientes
            Patient p4 = new Patient(null,"Nigel Mansel","(87)98846-4300", "16/12/1975");
            Patient p5 = new Patient(null,"Ayrton Senna","(85)98855-4200", "25/12/1995");
            Patient p6 = new Patient(null,"Alain Prost","(84)98850-2120", "25/02/2003");
            patientsRepository.saveAll(Arrays.asList(p4,p5,p6));

            // setup medicos
            Doctor d1 = new Doctor(1L, "José Carlos", "Cirurgião", "Cirurgias", "8425-1580");
            Doctor d2 = new Doctor(2L, "Mario Costa", "Pediatra", "Pediatria", "8425-1580");
            doctorsRepository.saveAll(Arrays.asList(d1,d2));

            // setup dos históricos
            Hospitalization h1 =  new Hospitalization(1L,p4, Arrays.asList(d1), "08/11/2017", "09/11/2017","EBOLA");
            Hospitalization h2 =  new Hospitalization(2L,p5, Arrays.asList(d2), "05/11/2016", "06/11/2016","Corona Virus ");
            Hospitalization h3 =  new Hospitalization(3L,p6, Arrays.asList(d1, d2), "05/11/2011", "06/11/2011","Gripe");

            hospitalizationHistoryRepository.saveAll(Arrays.asList(h1, h2, h3));
        }
    }

