package com.lt.vu.hospital.mybatis.dao;

import com.lt.vu.hospital.mybatis.Patient;
import java.util.List;

public interface PatientMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Patient record);

    Patient selectByPrimaryKey(Long id);

    List<Patient> selectAll();

    int updateByPrimaryKey(Patient record);
}