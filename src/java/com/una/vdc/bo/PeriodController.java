/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.bo;

import com.una.vdc.exception.DeleteException;
import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
import com.una.vdc.model.course.Period;
import com.una.vdc.persistence.DatabaseConnection;
import com.una.vdc.persistence.dao.CourseDAO;
import com.una.vdc.persistence.dao.PeriodDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class PeriodController {
    
    private final PeriodDAO dao;
    private final CourseDAO courseDAO;

    public PeriodController() {
        EntityManager em = DatabaseConnection.instance().getManager();
        dao = new PeriodDAO(em);  
        courseDAO = new CourseDAO(em);
    }
    
    
    public Period getPeriodById(Long id) {
        return dao.getById(id);
    }

    public List<Period> getAllPeriods() {
        return dao.findAll();
    }

    public void insertPeriod(Period p) throws InsertException {
        dao.save(p);
    }

    public void removePeriod(Period p) throws DeleteException {
        dao.delete(p);
    }

    public void updatePeriod(Period p) throws UpdateException {
        dao.update(p);
    }
    
    
}
