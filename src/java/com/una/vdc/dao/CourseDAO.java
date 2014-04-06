/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.dao;

import com.una.vdc.model.Course;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Ulrik
 */
public class CourseDAO extends GenericDAO<Long, Course>{

    
    public CourseDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
