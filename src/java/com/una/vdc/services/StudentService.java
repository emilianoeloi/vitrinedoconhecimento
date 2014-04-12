/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.services;

import com.google.gson.Gson;
import com.una.vdc.bo.StudentController;
import com.una.vdc.model.user.Student;
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
@Path("/students")
@Consumes(MediaType.APPLICATION_JSON)
public class StudentService {

    private StudentController studentController = new StudentController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentes() {

        List<Student> studentList = studentController.getAllStudents();
        String json = new Gson().toJson(studentList);
        return Response.ok().entity(json).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveStudent(String student_str) {
        try {
            Student student = new Gson().fromJson(student_str, Student.class);
            studentController.insertStudent(student);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception exc) {
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{_id}")
    public Response getStudent(@PathParam("_id") long id) {
        try {
            Student t = studentController.getStudentById(id);
            String json = new Gson().toJson(t);
            return Response.ok().entity(json).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{_id}")
    public Response deleteStudent(@PathParam("_id") long id) {
        try {
            
            Student deletedStudent = studentController.getStudentById(id);
            studentController.removeStudent(deletedStudent);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upadateStudent(String student_str) {
        try {
            Student updetedStudent = new Gson().fromJson(student_str, Student.class);
            studentController.updateStudent(updetedStudent);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
