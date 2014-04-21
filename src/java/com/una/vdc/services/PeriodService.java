/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.services;

import com.google.gson.Gson;
import com.una.vdc.bo.PeriodController;
import com.una.vdc.model.course.Period;
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
@Path("/periods")
@Consumes(MediaType.APPLICATION_JSON)
public class PeriodService {
    
    private Logger logger = Logger.getLogger("com.una.vdc.services");

    private PeriodController periodController = new PeriodController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPeriodes() {

        List<Period> periodList = periodController.getAllPeriods();
        String json = new Gson().toJson(periodList);
        return Response.ok().entity(json).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response savePeriod(String strPeriod) {
        try {
            Period period = new Gson().fromJson(strPeriod, Period.class);
            periodController.insertPeriod(period);
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
    public Response getPeriod(@PathParam("_id") long id) {
        Period t = periodController.getPeriodById(id);
        String json = new Gson().toJson(t);
        return Response.ok().entity(json).build();

    }

    @DELETE
    @Path("/{_id}")
    public Response deletePeriod(@PathParam("_id") long id) {
        try {
            
            Period deletedPeriod = periodController.getPeriodById(id);
            periodController.removePeriod(deletedPeriod);
            return Response.ok().build();
        } catch (Exception exc) {
            String json = new Gson().toJson(exc);
            logger.log(Level.ALL, exc.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(json).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upadatePeriod(String strPeriod) {
        try {
            Period updetedPeriod = new Gson().fromJson(strPeriod, Period.class);
            periodController.updatePeriod(updetedPeriod);
            return Response.ok().build();
        } catch (Exception exc) {
            String json = new Gson().toJson(exc);
            logger.log(Level.ALL, exc.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(json).build();
        }
    }
}
