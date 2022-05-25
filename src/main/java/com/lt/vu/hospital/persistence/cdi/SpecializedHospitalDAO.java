package com.lt.vu.hospital.persistence.cdi;

import com.lt.vu.hospital.entities.Hospital;
import com.lt.vu.hospital.persistence.HospitalDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;


@Specializes
@ApplicationScoped
public class SpecializedHospitalDAO extends HospitalDAO {
    @Inject
    private EntityManager em;

    public List<Hospital> showAll() {
        System.out.println("SpecializedHospitalDAO");
        return em.createNamedQuery("Hospital.findAll", Hospital.class).getResultList();
    }
}