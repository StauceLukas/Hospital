package com.lt.vu.hospital.mybatis;

import java.util.List;

public class Doctor {
    private Integer id;
    private String name;

    private List<Patient> patients;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}