package com.lt.vu.hospital.mybatis.dao;


import com.lt.vu.hospital.mybatis.model.Patient;
import java.util.List;

public interface PatientMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PATIENT
     *
     * @mbg.generated Mon Apr 04 22:47:13 EEST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PATIENT
     *
     * @mbg.generated Mon Apr 04 22:47:13 EEST 2022
     */
    int insert(Patient record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PATIENT
     *
     * @mbg.generated Mon Apr 04 22:47:13 EEST 2022
     */
    Patient selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PATIENT
     *
     * @mbg.generated Mon Apr 04 22:47:13 EEST 2022
     */
    List<Patient> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PATIENT
     *
     * @mbg.generated Mon Apr 04 22:47:13 EEST 2022
     */
    int updateByPrimaryKey(Patient record);
}