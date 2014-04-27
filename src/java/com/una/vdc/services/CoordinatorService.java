/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.services;

import com.google.gson.Gson;
import com.una.vdc.bo.CoordinatorController;
import com.una.vdc.model.user.Coordinator;
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
@Path("/coordinators")
@Consumes(MediaType.APPLICATION_JSON)
public class CoordinatorService {

    private CoordinatorController coordinatorController = new CoordinatorController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoordinatores() {

        List<Coordinator> coordinatorList = coordinatorController.getAllCoordinators();
        String json = new Gson().toJson(coordinatorList);
        return Response.ok().entity(json).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCoordinator(String strCoordinator) {
        try {
            Coordinator coordinator = new Gson().fromJson(strCoordinator, Coordinator.class);
            coordinatorController.insertCoordinator(coordinator);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception exc) {
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{_id}")
    public Response getCoordinator(@PathParam("_id") long id) {
        try {
            Coordinator t = coordinatorController.getCoordinatorById(id);
            String json = new Gson().toJson(t);
            return Response.ok().entity(json).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{_id}")
    public Response deleteCoordinator(@PathParam("_id") long id) {
        try {
            
            Coordinator deletedCoordinator = coordinatorController.getCoordinatorById(id);
            coordinatorController.removeCoordinator(deletedCoordinator);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upadateCoordinator(String strCoordinator) {
        try {
            Coordinator updetedCoordinator = new Gson().fromJson(strCoordinator, Coordinator.class);
            coordinatorController.updateCoordinator(updetedCoordinator);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
