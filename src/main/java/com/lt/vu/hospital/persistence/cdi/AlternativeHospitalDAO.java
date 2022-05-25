package com.lt.vu.hospital.persistence.cdi;

import com.lt.vu.hospital.entities.Hospital;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Alternative
@ApplicationScoped
public class AlternativeHospitalDAO implements IHospitalDAO {
    private List<Hospital> hospitals = new ArrayList<>(Arrays.asList(
            new Hospital(1L, "Santariskes", "Santariskiu 88"),
            new Hospital(2L, "Alytaus ligonine", "Alytaus 77"),
            new Hospital(3L, "Kardelitos poliklinika", "Karoliniskes 56"),
             new Hospital(4L, "Antakalnio ligonine", "Antakalnio 99"),
            new Hospital(5L, "Kauno ligonine", "Kauno 111"),
            new Hospital(6L, "Birstono poliklinika", "Vytauto 44")
    ));

    public List<Hospital> showAll() {
        return hospitals;
    }

    public void persist(Hospital hospital) {
        hospital.setId((long) (hospitals.size() + 1));
        hospitals.add(hospital);
    }

    public Hospital findOne(Long id) {
        for (Hospital hos : hospitals) {
            if(hos.getId() == id){
                return hos;
            }
        }
        return null;
    }
}