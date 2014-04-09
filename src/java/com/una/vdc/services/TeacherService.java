/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.services;

import com.google.gson.Gson;
<<<<<<< HEAD
import com.una.vdc.bo.MentorTeacherController;
import com.una.vdc.model.user.MentorTeacher;
import com.una.vdc.model.user.User;
import java.util.LinkedList;
=======
import com.una.vdc.bo.TeacherController;
import com.una.vdc.model.teacher.Teacher;
<<<<<<< HEAD
>>>>>>> 225483f53edbd12a6e71bd18eecc1a845e36aaca
=======
>>>>>>> 225483f53edbd12a6e71bd18eecc1a845e36aaca
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
<<<<<<< HEAD
<<<<<<< HEAD
    
    private MentorTeacherController teacherController = new MentorTeacherController();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeachers(){
        
        List<MentorTeacher> teacherList = teacherController.getAllTeachers();
=======

    private TeacherController teacherController = new TeacherController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
=======

    private TeacherController teacherController = new TeacherController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
>>>>>>> 225483f53edbd12a6e71bd18eecc1a845e36aaca
    public Response getTeachers() {

        List<Teacher> teacherList = teacherController.getAllTeachers();
>>>>>>> 225483f53edbd12a6e71bd18eecc1a845e36aaca
        String json = new Gson().toJson(teacherList);
        return Response.ok().entity(json).build();

    }

    @POST
<<<<<<< HEAD
<<<<<<< HEAD
    public Response saveTeacher(String teacher_str){
        MentorTeacher teacher = new  Gson().fromJson(teacher_str, MentorTeacher.class);
=======
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveTeacher(String teacher_str) {
        Teacher teacher = new Gson().fromJson(teacher_str, Teacher.class);
>>>>>>> 225483f53edbd12a6e71bd18eecc1a845e36aaca
=======
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveTeacher(String teacher_str) {
        Teacher teacher = new Gson().fromJson(teacher_str, Teacher.class);
>>>>>>> 225483f53edbd12a6e71bd18eecc1a845e36aaca
        teacherController.insertTeacher(teacher);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{_id}")
<<<<<<< HEAD
<<<<<<< HEAD
    public Response getTeacher(@PathParam("_id") long id){  
        MentorTeacher t = teacherController.getTeacherById(id);
        return Response.ok().entity(t).build();
=======
=======
>>>>>>> 225483f53edbd12a6e71bd18eecc1a845e36aaca
    public Response getTeacher(@PathParam("_id") long id) {
        try {
            Teacher t = teacherController.getTeacherById(id);
            String json = new Gson().toJson(t);
            if (json == null){
                json = "{}";
            }
            return Response.ok().entity(json).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
<<<<<<< HEAD
>>>>>>> 225483f53edbd12a6e71bd18eecc1a845e36aaca
=======
>>>>>>> 225483f53edbd12a6e71bd18eecc1a845e36aaca
    }

    @DELETE
    @Path("/{_id}")
<<<<<<< HEAD
<<<<<<< HEAD
    public Response deleteTeacher(@PathParam("_id") long id){
        MentorTeacher deletedTeacher = new MentorTeacher();
=======
    public Response deleteTeacher(@PathParam("_id") long id) {
        Teacher deletedTeacher = new Teacher();
>>>>>>> 225483f53edbd12a6e71bd18eecc1a845e36aaca
=======
    public Response deleteTeacher(@PathParam("_id") long id) {
        Teacher deletedTeacher = new Teacher();
>>>>>>> 225483f53edbd12a6e71bd18eecc1a845e36aaca
        deletedTeacher.setId(id);
        teacherController.removeTeacher(deletedTeacher);
        return Response.ok().build();
    }

    @PUT
<<<<<<< HEAD
<<<<<<< HEAD
    public Response upadateTeacher(String teacher_str ){
        MentorTeacher updetedTeacher = new Gson().fromJson(teacher_str, MentorTeacher.class);
=======
=======
>>>>>>> 225483f53edbd12a6e71bd18eecc1a845e36aaca
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upadateTeacher(String teacher_str) {
        Teacher updetedTeacher = new Gson().fromJson(teacher_str, Teacher.class);
>>>>>>> 225483f53edbd12a6e71bd18eecc1a845e36aaca
        teacherController.updateTeacher(updetedTeacher);
        return Response.ok().build();
    }
}
