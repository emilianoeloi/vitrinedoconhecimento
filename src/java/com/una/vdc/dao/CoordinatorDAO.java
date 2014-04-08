/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.dao;

import com.una.vdc.model.teacher.Coordinator;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class CoordinatorDAO extends GenericDAO<Long, Coordinator>{
    
    public CoordinatorDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
