/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.services;

import com.google.gson.Gson;
import com.una.vdc.bo.MentorTeacherController;
import com.una.vdc.model.user.MentorTeacher;
import com.una.vdc.model.user.User;
import java.util.LinkedList;
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
@Path("/teachers")
@Consumes(MediaType.APPLICATION_JSON)
public class TeacherService {
    
    private MentorTeacherController teacherController = new MentorTeacherController();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeachers(){
        
        List<MentorTeacher> teacherList = teacherController.getAllTeachers();
        String json = new Gson().toJson(teacherList);
        return Response.ok().entity(json).build();
        
    }
    
    @POST
    public Response saveTeacher(String teacher_str){
        MentorTeacher teacher = new  Gson().fromJson(teacher_str, MentorTeacher.class);
        teacherController.insertTeacher(teacher);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{_id}")
    public Response getTeacher(@PathParam("_id") long id){  
        MentorTeacher t = teacherController.getTeacherById(id);
        return Response.ok().entity(t).build();
    }
    
    @DELETE
    @Path("/{_id}")
    public Response deleteTeacher(@PathParam("_id") long id){
        MentorTeacher deletedTeacher = new MentorTeacher();
        deletedTeacher.setId(id);
        teacherController.removeTeacher(deletedTeacher);
        return Response.ok().build();
    }
    
    @PUT
    public Response upadateTeacher(String teacher_str ){
        MentorTeacher updetedTeacher = new Gson().fromJson(teacher_str, MentorTeacher.class);
        teacherController.updateTeacher(updetedTeacher);
        return Response.ok().build();
    }
}
