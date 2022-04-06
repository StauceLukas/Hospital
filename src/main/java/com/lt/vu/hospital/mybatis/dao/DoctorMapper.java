package com.lt.vu.hospital.mybatis.dao;

import com.lt.vu.hospital.mybatis.Doctor;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface DoctorMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Doctor record);

    Doctor selectByPrimaryKey(Integer id);

    @Select("SELECT ID, NAME FROM PUBLIC.DOCTOR")
    List<Doctor> selectAll();

    int updateByPrimaryKey(Doctor record);

}