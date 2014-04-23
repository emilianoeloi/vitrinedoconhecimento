/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

import com.una.vdc.exception.DeleteException;
import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
import com.una.vdc.model.project.TIDIRStage;
import com.una.vdc.persistence.dao.CoordinatorDAO;
import com.una.vdc.model.user.Coordinator;
import com.una.vdc.persistence.DatabaseConnection;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class CoordinatorController {

    private final CoordinatorDAO dao;

    public CoordinatorController() {
        EntityManager em = DatabaseConnection.instance().getManager();
        dao = new CoordinatorDAO(em);
    }

    public Coordinator getCoordinatorById(Long id) {
        return dao.getById(id);
    }

    public List<Coordinator> getAllCoordinators() {
        return dao.findAll();
    }

    public void insertCoordinator(Coordinator c) throws InsertException {
        dao.save(c);
    }

    public void removeCoordinator(Coordinator c) throws DeleteException {
        dao.delete(c);
    }

    public void updateCoordinator(Coordinator c) throws UpdateException {
        dao.update(c);
    }
    
    public void createStage(TIDIRStage s) throws InsertException{
        dao.createStage(s);
    }

}
