package com.lt.vu.hospital.persistence;

import com.lt.vu.hospital.entities.Patient;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PatientDAO {

    @Inject
    private EntityManager em;

    public List<Patient> loadAll() {
        return em.createNamedQuery("Patient.findAll", Patient.class).getResultList();
    }

    public void persist(Patient patient){
        this.em.persist(patient);
    }

    public Patient findOne(Integer id){
        return em.find(Patient.class, id);
    }
}