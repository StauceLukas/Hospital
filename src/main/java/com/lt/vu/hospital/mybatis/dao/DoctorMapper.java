package com.lt.vu.hospital.mybatis.dao;

import com.lt.vu.hospital.mybatis.Doctor;
import org.apache.ibatis.annotations.Select;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface DoctorMapper {
    int insert(Doctor record);
    List<Doctor> selectAll();
}