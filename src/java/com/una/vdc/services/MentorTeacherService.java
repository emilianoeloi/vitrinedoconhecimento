/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.services;

import com.google.gson.Gson;
import com.una.vdc.bo.MentorTeacherController;
import com.una.vdc.model.user.MentorTeacher;
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
@Path("/mentorteachers")
@Consumes(MediaType.APPLICATION_JSON)
public class MentorTeacherService {

    private MentorTeacherController mentorTeacherController = new MentorTeacherController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMentorTeacheres() {

        List<MentorTeacher> mentorTeacherList = mentorTeacherController.getAllTeachers();
        String json = new Gson().toJson(mentorTeacherList);
        return Response.ok().entity(json).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveMentorTeacher(String strMentorTeacher) {
        try {
            MentorTeacher mentorTeacher = new Gson().fromJson(strMentorTeacher, MentorTeacher.class);
            mentorTeacherController.insertTeacher(mentorTeacher);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception exc) {
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{_id}")
    public Response getMentorTeacher(@PathParam("_id") long id) {
        try {
            MentorTeacher t = mentorTeacherController.getTeacherById(id);
            String json = new Gson().toJson(t);
            return Response.ok().entity(json).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{_id}")
    public Response deleteMentorTeacher(@PathParam("_id") long id) {
        try {
            
            MentorTeacher deletedMentorTeacher = mentorTeacherController.getTeacherById(id);
            mentorTeacherController.removeTeacher(deletedMentorTeacher);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upadateMentorTeacher(String strMentorTeacher) {
        try {
            MentorTeacher updetedMentorTeacher = new Gson().fromJson(strMentorTeacher, MentorTeacher.class);
            mentorTeacherController.updateTeacher(updetedMentorTeacher);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
