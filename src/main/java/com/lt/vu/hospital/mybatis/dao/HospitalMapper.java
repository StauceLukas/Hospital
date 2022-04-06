package com.lt.vu.hospital.mybatis.dao;

import com.lt.vu.hospital.mybatis.Hospital;
import org.apache.ibatis.annotations.Select;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface HospitalMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Hospital record);

    Hospital selectByPrimaryKey(Long id);
    @Select("SELECT ID, ADDRESS, TITLE FROM PUBLIC.HOSPITAL")
    List<Hospital> selectAll();

    int updateByPrimaryKey(Hospital record);
}