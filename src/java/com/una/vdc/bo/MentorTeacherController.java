/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

import com.una.vdc.persistence.dao.MentorTeacherDAO;
import com.una.vdc.persistence.DatabaseConnection;
import com.una.vdc.exception.InsertException;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.user.MentorTeacher;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class MentorTeacherController {

    private MentorTeacherDAO dao;

    public MentorTeacherController() {
        EntityManager em = DatabaseConnection.instance().getManager();
        dao = new MentorTeacherDAO(em);
    }

    public void associateTeacherToClass(MentorTeacher teacher, CollegeClass cclass) {
//            dao.associateTeacherToClass(teacher, cclass);
    }
    
    public List<MentorTeacher> getTeachersByClass(Long idClass){
//        return dao.getTeachersByCollegeClass(idClass);
        return null;
    }

    public MentorTeacher getTeacherById(Long id) {
        return dao.getById(id);
    }

    public List<MentorTeacher> getAllTeachers() {
        return dao.findAll();
    }

    public void insertTeacher(MentorTeacher teacher) {
        dao.save(teacher);
    }

    public void removeTeacher(MentorTeacher teacher) {
        dao.delete(teacher);
    }
    
    public void updateTeacher(MentorTeacher teacher){
        dao.update(teacher);
    }
}