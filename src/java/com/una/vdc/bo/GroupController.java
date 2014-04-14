/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
import com.una.vdc.model.project.TIDIRGroup;
import com.una.vdc.persistence.DatabaseConnection;
import com.una.vdc.persistence.dao.GroupDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.GroupLayout.Group;

/**
 *
 * @author daniel
 */
public class GroupController {

    private final GroupDAO dao;

    public GroupController() {
        EntityManager em = DatabaseConnection.instance().getManager();
        dao = new GroupDAO(em);
    }

    public TIDIRGroup getGroupById(Long id) {
        return dao.getById(id);
    }

    public List<TIDIRGroup> getAllGroups() {
        return dao.findAll();
    }

    public void insertGroup(TIDIRGroup g) throws InsertException {
        dao.save(g);
    }

    public void removeGroup(TIDIRGroup g) throws UpdateException {
        dao.delete(g);
    }

    public void updateGroup(TIDIRGroup g) throws UpdateException {
        dao.update(g);
    }

}
