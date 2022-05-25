package com.lt.vu.hospital.persistence;
import com.lt.vu.hospital.entities.Hospital;
import com.lt.vu.hospital.persistence.cdi.IHospitalDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class HospitalDAO implements IHospitalDAO {

    @Inject
    private EntityManager em;

    public List<Hospital> showAll() {
        return em.createNamedQuery("Hospital.findAll", Hospital.class).getResultList();
    }

    @Transactional
    public void persist(Hospital hospital){
        this.em.persist(hospital);
    }

    public Hospital findOne(Long id){
        return em.find(Hospital.class, id);
    }

}