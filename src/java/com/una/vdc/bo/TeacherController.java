/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

import com.una.vdc.dao.TeacherDAO;
import com.una.vdc.persistencia.DatabaseConnection;
import com.una.vdc.exception.InsertException;
import com.una.vdc.model.CollegeClass;
import com.una.vdc.model.Teacher;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class TeacherController {

    private TeacherDAO dao;

    public TeacherController() {
        EntityManager em = DatabaseConnection.instance().getManager();
        dao = new TeacherDAO(em);
    }

    public void associateTeacherToClass(Teacher teacher, CollegeClass cclass) {
        try {
            dao.associateTeacherToClass(teacher, cclass);
        } catch (InsertException ex) {
            Logger.getLogger(TeacherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Teacher> getTeachersByClass(Long idClass){
        return dao.getTeachersByCollegeClass(idClass);
    }

    public Teacher getTeacherById(Long id) {
        return dao.getById(id);
    }

    public List<Teacher> getAllTeachers() {
        return dao.findAll();
    }

    public void insertTeacher(Teacher teacher) {
        dao.save(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        dao.delete(teacher);
    }
    
    public void updateTeacher(Teacher teacher){
        dao.update(teacher);
    }
}
