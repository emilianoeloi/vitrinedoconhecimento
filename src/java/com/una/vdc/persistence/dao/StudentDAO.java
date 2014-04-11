/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.model.project.TIDIRGroup;
import com.una.vdc.model.user.Student;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class StudentDAO extends GenericDAO<Long, Student> {

    
    public StudentDAO(EntityManager entityManager) {
        super(entityManager);
    }

}
