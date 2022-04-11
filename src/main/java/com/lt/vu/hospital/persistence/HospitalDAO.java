package com.lt.vu.hospital.persistence;
import com.lt.vu.hospital.entities.Hospital;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class HospitalDAO {

    @Inject
    private EntityManager em;

    public List<Hospital> loadAll() {
        return em.createNamedQuery("Hospital.findAll", Hospital.class).getResultList();
    }

    public void persist(Hospital hospital){
        this.em.persist(hospital);
    }

    public Hospital findOne(Long id){
        return em.find(Hospital.class, id);
    }

}