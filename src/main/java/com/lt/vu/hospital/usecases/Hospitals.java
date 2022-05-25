package com.lt.vu.hospital.usecases;

import com.lt.vu.hospital.entities.Hospital;

import com.lt.vu.hospital.interceptors.LoggedInvocation;
import com.lt.vu.hospital.persistence.cdi.IHospitalDAO;
import lombok.Getter;
import lombok.Setter;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Hospitals{
    @Inject
    private IHospitalDAO hospitalDAO;


    @Getter
    private List<Hospital> allHospitals;

    @Getter
    @Setter
    private Hospital hospitalToCreate = new Hospital();

    @PostConstruct
    public void init(){
        loadAllLibraries();
    }


    @LoggedInvocation
    public void createHospital(){
        hospitalDAO.persist(hospitalToCreate);
    }

    private void loadAllLibraries(){
        this.allHospitals = hospitalDAO.showAll();
    }

}