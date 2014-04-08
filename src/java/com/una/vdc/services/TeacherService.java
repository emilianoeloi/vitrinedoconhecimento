/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.services;

import com.google.gson.Gson;
import com.una.vdc.bo.TeacherController;
import com.una.vdc.model.Teacher;
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
    
    private TeacherController teacherController = new TeacherController();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeachers(){
        
        List<Teacher> teacherList = teacherController.getAllTeachers();
        String json = new Gson().toJson(teacherList);
        return Response.ok().entity(json).build();
        
    }
    
    @POST
    public Response saveTeacher(String teacher_str){
        Teacher teacher = new  Gson().fromJson(teacher_str, Teacher.class);
        teacherController.insertTeacher(teacher);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{_id}")
    public Response getTeacher(@PathParam("_id") long id){  
        Teacher t = teacherController.getTeacherById(id);
        return Response.ok().entity(t).build();
    }
    
    @DELETE
    @Path("/{_id}")
    public Response deleteTeacher(@PathParam("_id") long id){
        Teacher deletedTeacher = new Teacher();
        deletedTeacher.setId(id);
        teacherController.removeTeacher(deletedTeacher);
        return Response.ok().build();
    }
    
    @PUT
    public Response upadateTeacher(String teacher_str ){
        Teacher updetedTeacher = new Gson().fromJson(teacher_str, Teacher.class);
        teacherController.updateTeacher(updetedTeacher);
        return Response.ok().build();
    }
}
