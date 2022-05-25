package com.lt.vu.hospital.persistence;

import com.lt.vu.hospital.entities.Doctor;
import com.lt.vu.hospital.rest.contracts.PutDoctorDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class DoctorDAO {
    @Inject
    private EntityManager em;

    public List<Doctor> loadAll() {
        return em.createNamedQuery("Doctor.findAll", Doctor.class).getResultList();
    }
    public void persist(Doctor doctor){
        this.em.persist(doctor);
    }
    public Doctor findOne(Integer id){
        return em.find(Doctor.class, id);
    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void update_one(PutDoctorDTO dto) throws InterruptedException {
        Doctor doctor = em.find(Doctor.class, dto.doctorId);
        Thread.sleep(6000);
        doctor.setName(dto.name);
        em.flush();
    }

    @Transactional
    public void update_two(PutDoctorDTO dto){
        Doctor doc = em.find(Doctor.class, dto.doctorId);
        doc.setName(dto.name);
        em.persist(doc);
    }

}