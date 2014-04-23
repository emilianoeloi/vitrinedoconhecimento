/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

import com.una.vdc.exception.DeleteException;
import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
import com.una.vdc.model.project.TIDIRProject;
import com.una.vdc.persistence.DatabaseConnection;
import com.una.vdc.persistence.dao.ProjectDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class ProjectController {

    private final ProjectDAO dao;

    public ProjectController() {
        EntityManager em = DatabaseConnection.instance().getManager();
        dao = new ProjectDAO(em);
    }

    public List<TIDIRProject> getProjectsByName(String projectName){
        return dao.getProjectsByName(projectName);
    }
    
    public TIDIRProject getProjectById(Long id) {
        return dao.getById(id);
    }

    public List<TIDIRProject> getAllProjects() {
        return dao.findAll();
    }

    public void insertProject(TIDIRProject p) throws InsertException {
        dao.save(p);
    }

    public void removeProject(TIDIRProject p) throws DeleteException {
        dao.delete(p);
    }

    public void updateProject(TIDIRProject p) throws UpdateException {
        dao.update(p);
    }

}
