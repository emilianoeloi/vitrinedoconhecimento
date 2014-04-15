/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.services;

import com.google.gson.Gson;
import com.una.vdc.bo.CollegeClassController;
import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
import com.una.vdc.model.course.CollegeClass;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private Logger logger = Logger.getLogger("com.una.vdc.services");

    private CollegeClassController collegeClassController = new CollegeClassController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCollegeClasses() {

        List<CollegeClass> collegeClassList = collegeClassController.getAllCollegeClasses();
        String json = new Gson().toJson(collegeClassList);
        return Response.ok().entity(json).build();

    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response searchCollegeClasses(String strCollegeClass) {
        CollegeClass collegeClass = new Gson().fromJson(strCollegeClass, CollegeClass.class);
        List<CollegeClass> collegeClassList = collegeClassController.getCollegeClassByName(collegeClass);
        String json = new Gson().toJson(collegeClassList);
        return Response.ok().entity(json).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCollegeClass(String strCollegeClass) {
        try {
            CollegeClass collegeClass = new Gson().fromJson(strCollegeClass, CollegeClass.class);
            collegeClassController.insertCollegeClass(collegeClass);
            return Response.status(Response.Status.CREATED).build();
        } catch (InsertException exc) {
            String json = new Gson().toJson(exc);
            logger.log(Level.ALL, exc.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(json).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{_id}")
    public Response getCollegeClass(@PathParam("_id") long id) {
        CollegeClass t = collegeClassController.getCollegeClassById(id);
        String json = new Gson().toJson(t);
        return Response.ok().entity(json).build();

    }

    @DELETE
    @Path("/{_id}")
    public Response deleteCollegeClass(@PathParam("_id") long id) {
        try {
            
            CollegeClass deletedCollegeClass = collegeClassController.getCollegeClassById(id);
            collegeClassController.removeCollegeClass(deletedCollegeClass);
            return Response.ok().build();
        } catch (UpdateException exc) {
            String json = new Gson().toJson(exc);
            logger.log(Level.ALL, exc.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(json).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upadateCollegeClass(String strCollegeClass) {
        try {
            CollegeClass updetedCollegeClass = new Gson().fromJson(strCollegeClass, CollegeClass.class);
            collegeClassController.updateCollegeClass(updetedCollegeClass);
            return Response.ok().build();
        } catch (UpdateException exc) {
            String json = new Gson().toJson(exc);
            logger.log(Level.ALL, exc.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(json).build();
        }
    }
}
