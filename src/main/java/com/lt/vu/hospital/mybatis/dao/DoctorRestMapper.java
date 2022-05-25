package com.lt.vu.hospital.mybatis.dao;

import com.lt.vu.hospital.entities.Doctor;
import com.lt.vu.hospital.rest.contracts.PostDoctorDTO;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DoctorRestMapper {
    public Doctor CreateDoctorFromDTO(PostDoctorDTO dto){
        Doctor doctor = new Doctor();
        doctor.setName(dto.name);
        return doctor;
    }
}