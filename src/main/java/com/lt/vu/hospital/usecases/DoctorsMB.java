package com.lt.vu.hospital.usecases;

import com.lt.vu.hospital.mybatis.Doctor;
import com.lt.vu.hospital.mybatis.dao.DoctorMapper;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class DoctorsMB {
    @Inject
    private DoctorMapper doctorMapper;

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
        doctorMapper.insert(doctorToCreate);
    }

    private void loadAllDoctors(){
        allDoctors = doctorMapper.selectAll();
    }
}
