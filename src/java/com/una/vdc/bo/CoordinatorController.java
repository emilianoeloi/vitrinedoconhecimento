/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

import com.una.vdc.dao.CoordinatorDAO;
import com.una.vdc.model.CollegeClass;
import com.una.vdc.model.Coordinator;
import com.una.vdc.persistencia.DatabaseConnection;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class CoordinatorController {

    private CoordinatorDAO dao;

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

    public void insertCoordinator(Coordinator c) {
        dao.save(c);
    }

    public void removeCoordinator(Coordinator c) {
        dao.delete(c);
    }

    public void updateCoordinator(Coordinator c) {
        dao.update(c);
    }

}
