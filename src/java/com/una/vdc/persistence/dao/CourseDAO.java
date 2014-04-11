/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.persistence.dao;

import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.course.Course;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class CourseDAO extends GenericDAO<Long, Course>{

    
    public CourseDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
