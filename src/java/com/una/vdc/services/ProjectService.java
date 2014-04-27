/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.services;

import com.google.gson.Gson;
import com.una.vdc.bo.ProjectController;
import com.una.vdc.model.project.TIDIRProject;
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
@Path("/tidirprojects")
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectService {
    
    private Logger logger = Logger.getLogger("com.una.vdc.services");

    private ProjectController projectController = new ProjectController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjectes() {

        List<TIDIRProject> projectList = projectController.getAllProjects();
        String json = new Gson().toJson(projectList);
        return Response.ok().entity(json).build();

    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response searchProjectes(String strProject) {
        TIDIRProject project = new Gson().fromJson(strProject, TIDIRProject.class);
        List<TIDIRProject> projectList = projectController.getProjectsByName(project.getProjectName());
        String json = new Gson().toJson(projectList);
        return Response.ok().entity(json).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveProject(String strProject) {
        try {
            TIDIRProject project = new Gson().fromJson(strProject, TIDIRProject.class);
            projectController.insertProject(project);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception exc) {
            String json = new Gson().toJson(exc);
            logger.log(Level.ALL, exc.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(json).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{_id}")
    public Response getProject(@PathParam("_id") long id) {
        TIDIRProject t = projectController.getProjectById(id);
        String json = new Gson().toJson(t);
        return Response.ok().entity(json).build();

    }

    @DELETE
    @Path("/{_id}")
    public Response deleteProject(@PathParam("_id") long id) {
        try {
            
            TIDIRProject deletedProject = projectController.getProjectById(id);
            projectController.removeProject(deletedProject);
            return Response.ok().build();
        } catch (Exception exc) {
            String json = new Gson().toJson(exc);
            logger.log(Level.ALL, exc.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(json).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upadateProject(String strProject) {
        try {
            TIDIRProject updetedProject = new Gson().fromJson(strProject, TIDIRProject.class);
            projectController.updateProject(updetedProject);
            return Response.ok().build();
        } catch (Exception exc) {
            String json = new Gson().toJson(exc);
            logger.log(Level.ALL, exc.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(json).build();
        }
    }
}
