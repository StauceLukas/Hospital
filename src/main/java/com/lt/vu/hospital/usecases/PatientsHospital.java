package com.lt.vu.hospital.usecases;

import com.lt.vu.hospital.entities.Hospital;
import com.lt.vu.hospital.persistence.HospitalDAO;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.cdi.Param;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class PatientsHospital {
    @Inject
    private HospitalDAO hospitalDAO;

    @Getter
    @Param
    private Long hospitalId;

    @Getter
    @Setter
    private Hospital hospital;

    @PostConstruct
    public void init(){
        if(hospitalId != null){
            this.hospital = hospitalDAO.findOne(hospitalId);
        }
    }
}
