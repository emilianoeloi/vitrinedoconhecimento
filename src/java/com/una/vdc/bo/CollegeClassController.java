/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

import com.una.vdc.exception.DeleteException;
import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.course.Period;
import com.una.vdc.persistence.DatabaseConnection;
import com.una.vdc.persistence.dao.CollegeClassDAO;
import com.una.vdc.persistence.dao.MentorTeacherDAO;
import com.una.vdc.persistence.dao.PeriodDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class CollegeClassController {
    
    private final CollegeClassDAO dao;
    private final PeriodDAO periodDAO;
    private final MentorTeacherDAO mentorTeacherDAO;

    public CollegeClassController() {
        EntityManager em = DatabaseConnection.instance().getManager();
        dao = new CollegeClassDAO(em);
        periodDAO = new PeriodDAO(em);
        mentorTeacherDAO = new MentorTeacherDAO(em);
    }

    public CollegeClass getCollegeClassById(Long id) {
        return dao.getById(id);
    }
    
    public List<CollegeClass> getCollegeClassByName(String name, Long idCourse) {
        return dao.getCollegeClassesByName(name, idCourse);
    }

    public List<CollegeClass> getAllCollegeClasses() {
        return dao.findAll();
    }

    public void insertCollegeClass(CollegeClass c) throws InsertException {
        if(c.getPeriod() != null && c.getPeriod().getId() != null){
            c.setPeriod(periodDAO.getById(c.getPeriod().getId()));
        }
        c.setMentorTeacher(mentorTeacherDAO.getById(c.getMentorTeacher().getId()));
        dao.save(c);
    }

    public void removeCollegeClass(CollegeClass c) throws DeleteException {
        dao.delete(c);
    }

    public void updateCollegeClass(CollegeClass c) throws UpdateException {
        dao.update(c);
    }

}
