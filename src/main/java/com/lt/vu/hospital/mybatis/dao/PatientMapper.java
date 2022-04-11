package com.lt.vu.hospital.mybatis.dao;

import com.lt.vu.hospital.mybatis.Patient;
import org.mybatis.cdi.Mapper;


@Mapper
public interface PatientMapper {
    int insert(Patient record);
}