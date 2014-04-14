/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.persistence.dao;

import com.una.vdc.exception.InsertException;
import com.una.vdc.model.project.TIDIRStage;
import com.una.vdc.model.user.Coordinator;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class CoordinatorDAO extends GenericDAO<Long, Coordinator>{
    
    public CoordinatorDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
    public void createStage(TIDIRStage stage) throws InsertException{
        try {
            et.begin();
            em.merge(stage);
            et.commit();
        } catch (Exception e) {
            throw new InsertException(e.getMessage());
        }
    }
    
}
