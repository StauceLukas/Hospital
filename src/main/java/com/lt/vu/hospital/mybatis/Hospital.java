package com.lt.vu.hospital.mybatis;

import java.util.List;

public class Hospital {
    private Long id;
    private String address;
    private String title;

    private List<Patient> patients;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


}