/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.dao;

import com.una.vdc.model.CollegeClass;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class CollegeClassDAO extends GenericDAO<Long, CollegeClass>{

    
    public CollegeClassDAO(EntityManager entityManager) {
        super(entityManager);
    }

    
    
}
