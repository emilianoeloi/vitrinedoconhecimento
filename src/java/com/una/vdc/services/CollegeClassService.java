/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.services;

import com.google.gson.Gson;
import com.una.vdc.bo.CollegeClassController;
import com.una.vdc.model.course.CollegeClass;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author emilianoeloi
 */
@Path("/collegeclasses")
@Consumes(MediaType.APPLICATION_JSON)
public class CollegeClassService {

    private CollegeClassController collegeClassController = new CollegeClassController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCollegeClasses() {

        List<CollegeClass> collegeClassList = collegeClassController.getAllCollegeClasses();
        String json = new Gson().toJson(collegeClassList);
        return Response.ok().entity(json).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCollegeClass(String collegeClass_str) {
        CollegeClass collegeClass = new Gson().fromJson(collegeClass_str, CollegeClass.class);
        collegeClassController.insertCollegeClass(collegeClass);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{_id}")
    public Response getCollegeClass(@PathParam("_id") long id) {
        try {
            CollegeClass t = collegeClassController.getCollegeClassById(id);
            String json = new Gson().toJson(t);
            return Response.ok().entity(json).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{_id}")
    public Response deleteCollegeClass(@PathParam("_id") long id) {
        CollegeClass deletedCollegeClass = new CollegeClass();
        deletedCollegeClass.setId(id);
        collegeClassController.removeCollegeClass(deletedCollegeClass);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upadateCollegeClass(String collegeClass_str) {
        CollegeClass updetedCollegeClass = new Gson().fromJson(collegeClass_str, CollegeClass.class);
        collegeClassController.updateCollegeClass(updetedCollegeClass);
        return Response.ok().build();
    }
}
