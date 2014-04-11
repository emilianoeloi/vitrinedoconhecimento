/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
import com.una.vdc.persistence.dao.CollegeClassDAO;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.persistence.DatabaseConnection;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class CollegeClassController {
    
    private final CollegeClassDAO dao;

    public CollegeClassController() {
        EntityManager em = DatabaseConnection.instance().getManager();
        dao = new CollegeClassDAO(em);
    }

    public CollegeClass getCollegeClassById(Long id) {
        return dao.getById(id);
    }

    public List<CollegeClass> getAllCollegeClasses() {
        return dao.findAll();
    }

    public void insertCollegeClass(CollegeClass c) throws InsertException {
        dao.save(c);
    }

    public void removeCollegeClass(CollegeClass c) throws UpdateException {
        dao.delete(c);
    }

    public void updateCollegeClass(CollegeClass c) throws UpdateException {
        dao.update(c);
    }

}
