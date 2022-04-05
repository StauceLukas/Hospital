package com.lt.vu.hospital.usecases;

import com.lt.vu.hospital.entities.Patient;
import com.lt.vu.hospital.persistence.PatientDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Patients {
    @Inject
    private PatientDAO patientDAO;

    @Getter
    private List<Patient> allPatients;

    @Getter
    @Setter
    private Patient patientToCreate = new Patient();

    @PostConstruct
    public void init(){
        loadAllPatients();
    }

    @Transactional
    public void createPatient(){
        patientDAO.persist(patientToCreate);
    }

    private void loadAllPatients(){
        allPatients = patientDAO.loadAll();
    }
}
