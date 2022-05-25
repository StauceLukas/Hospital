package com.lt.vu.hospital.rest;

import com.lt.vu.hospital.entities.Doctor;
import com.lt.vu.hospital.mybatis.dao.DoctorRestMapper;
import com.lt.vu.hospital.persistence.DoctorDAO;
import com.lt.vu.hospital.rest.contracts.PostDoctorDTO;
import com.lt.vu.hospital.rest.contracts.PutDoctorDTO;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/doctors")
@Produces(MediaType.APPLICATION_JSON)
public class DoctorController {
    @Inject
    DoctorDAO doctorDAO;

    @Inject
    DoctorRestMapper doctorMapper;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        Doctor doc = doctorDAO.findOne(id);
        if (doc == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(doc).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Doctor create(PostDoctorDTO dto) {
        Doctor doctor = doctorMapper.CreateDoctorFromDTO(dto);
        doctorDAO.persist(doctor);
        return doctor;
    }

    @PUT
    @Path("/update-1")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update_one(PutDoctorDTO dto) throws InterruptedException {
        try{
            doctorDAO.update_one(dto);
            return Response.ok().build();
        } catch (OptimisticLockException ex){
            System.out.println(ex);
            return Response.status(Response.Status.CONFLICT).build();
        }
        catch (Exception ex){
            System.out.println(ex);
            return Response.noContent().build();
        }
    }
    @PUT
    @Path("/update-2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update_two(PutDoctorDTO dto) {
        try{
            doctorDAO.update_two(dto);
            return Response.ok().build();
        }
        catch (Exception ex){
            System.out.println(ex);
            return Response.noContent().build();
        }
    }
}