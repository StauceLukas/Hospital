package com.lt.vu.hospital.usecases;


import com.lt.vu.hospital.entities.Doctor;
import com.lt.vu.hospital.persistence.DoctorDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Doctors {
    @Inject
    private DoctorDAO doctorDAO;

    @Getter
    private List<Doctor> allDoctors;

    @Getter
    @Setter
    private Doctor doctorToCreate = new Doctor();

    @PostConstruct
    public void init(){
        loadAllDoctors();
    }

    @Transactional
    public void createDoctor(){
        doctorDAO.persist(doctorToCreate);
    }

    private void loadAllDoctors(){
        allDoctors = doctorDAO.loadAll();
    }
}