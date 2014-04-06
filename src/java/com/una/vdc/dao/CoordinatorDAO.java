/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.dao;

import com.una.vdc.model.Coordinator;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Ulrik
 */
public class CoordinatorDAO extends GenericDAO<Long, Coordinator>{
    
    public CoordinatorDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
