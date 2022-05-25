package com.lt.vu.hospital.persistence.cdi;

import com.lt.vu.hospital.entities.Hospital;
import java.util.List;

public interface IHospitalDAO {
    List<Hospital> showAll();
    void persist(Hospital hospital);
    Hospital findOne(Long id);
}