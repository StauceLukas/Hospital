package com.lt.vu.hospital.persistence;

import com.lt.vu.hospital.entities.Doctor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class DoctorDAO {
    @Inject
    private EntityManager em;

    public List<Doctor> loadAll() {
        return em.createNamedQuery("Doctor.findAll", Doctor.class).getResultList();
    }

    public void persist(Doctor doctor){
        this.em.persist(doctor);
    }

    public Doctor findOne(Long id){
        return em.find(Doctor.class, id);
    }

}