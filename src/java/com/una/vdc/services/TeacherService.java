/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.services;

import com.google.gson.Gson;
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
public class TeacherService {
    
    
    private static List<Teacher> teacherList = new LinkedList<Teacher>();
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeachers(){
        String json = new Gson().toJson(teacherList);
        return Response.ok().entity(json).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveTeacher(String teacher_str){
        Teacher teacher = new  Gson().fromJson(teacher_str, Teacher.class);
        teacherList.add(teacher);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{_id}")
    public Response getTeacher(@PathParam("_id") int id){
        for (Teacher teacher : teacherList) {
            if (teacher.getId() == id){
                String json = new Gson().toJson(teacher);
                return Response.ok().entity(json).build();
            }
        }
        return Response.ok().entity("{}").build();
    }
    
    @DELETE
    @Path("/{_id}")
    public Response deleteTeacher(@PathParam("_id") Long id){
         teacherList.remove(new Teacher(id));
         return Response.ok().build();
    }
    
    @PUT
    public Response upadateTeacher(String teacher_str ){
        Teacher updetedTeacher = new Gson().fromJson(teacher_str, Teacher.class);
        
        for (Teacher teacher : teacherList) {
            if (teacher.getId() == updetedTeacher.getId()){
                teacher.setName(updetedTeacher.getName());
            }
        }
        return Response.ok().build();
    }
}
