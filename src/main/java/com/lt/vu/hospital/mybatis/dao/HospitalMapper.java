package com.lt.vu.hospital.mybatis.dao;

import com.lt.vu.hospital.mybatis.Hospital;
import org.apache.ibatis.annotations.Select;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface HospitalMapper {
    int insert(Hospital record);
    List<Hospital> selectAll();
}