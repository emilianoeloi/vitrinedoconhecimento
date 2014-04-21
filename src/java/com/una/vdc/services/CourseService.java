/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.services;

import com.google.gson.Gson;
import com.una.vdc.bo.CourseController;
import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
import com.una.vdc.model.course.Course;
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
@Path("/courses")
@Consumes(MediaType.APPLICATION_JSON)
public class CourseService {

    private Logger logger = Logger.getLogger("com.una.vdc.services");

    private CourseController courseController = new CourseController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursees() {
        try {
            List<Course> courseList = courseController.getAllCourses();
            String json = new Gson().toJson(courseList);
            return Response.ok().entity(json).build();
        } catch (Exception exc) {
            String json = new Gson().toJson(exc);
            logger.log(Level.ALL, exc.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(json).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCourse(String strCourse) {
        try {
            Course course = new Gson().fromJson(strCourse, Course.class);
            courseController.insertCourse(course);
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
    public Response getCourse(@PathParam("_id") long id) {
        Course t = courseController.getCourseById(id);
        String json = new Gson().toJson(t);
        return Response.ok().entity(json).build();

    }

    @DELETE
    @Path("/{_id}")
    public Response deleteCourse(@PathParam("_id") long id) {
        try {

            Course deletedCourse = courseController.getCourseById(id);
            courseController.removeCourse(deletedCourse);
            return Response.ok().build();
        } catch (UpdateException exc) {
            String json = new Gson().toJson(exc);
            logger.log(Level.ALL, exc.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(json).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upadateCourse(String strCourse) {
        try {
            Course updetedCourse = new Gson().fromJson(strCourse, Course.class);
            courseController.updateCourse(updetedCourse);
            return Response.ok().build();
        } catch (UpdateException exc) {
            String json = new Gson().toJson(exc);
            logger.log(Level.ALL, exc.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(json).build();
        }
    }
}
