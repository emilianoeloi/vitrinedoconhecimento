/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.persistence.dao;

import com.una.vdc.model.project.TIDIRProject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author daniel
 */
public class ProjectDAO extends GenericDAO<Long, TIDIRProject>{

    public ProjectDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
    public List<TIDIRProject> getProjectsByName(String projectName){
        Query query = em.createQuery("Select p FROM TIDIRProject p WHERE p.projectName like :n");
        query.setParameter("n", "%"+projectName+"%");
        return query.getResultList();
    }
    
}
