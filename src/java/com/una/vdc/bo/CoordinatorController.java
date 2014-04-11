<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

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
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
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

    public void removeCoordinator(Coordinator c) throws UpdateException {
        dao.delete(c);
    }

    public void updateCoordinator(Coordinator c) throws UpdateException {
        dao.update(c);
    }

}
>>>>>>> 613f669a22e9b2b6f8de3f0a0dce662163a3a277
