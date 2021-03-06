/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

import com.una.vdc.exception.AssociationException;
import com.una.vdc.exception.DeleteException;
import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
import com.una.vdc.persistence.dao.MentorTeacherDAO;
import com.una.vdc.persistence.DatabaseConnection;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.user.MentorTeacher;
import com.una.vdc.model.user.User;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class MentorTeacherController {

    private final MentorTeacherDAO dao;

    public MentorTeacherController() {
        EntityManager em = DatabaseConnection.instance().getManager();
        dao = new MentorTeacherDAO(em);
    }

    public void associateModuleTeacherToClass(MentorTeacher teacher, CollegeClass cclass)
            throws AssociationException {
        dao.associateTeacherToClass(teacher, cclass);
    }
    
    public MentorTeacher getTeacherByClass(Long idClass){
        return dao.getMentorTeacherByClass(idClass);
    }

    public MentorTeacher getTeacherById(Long id) {
        return dao.getById(id);
    }

    public List<MentorTeacher> getAllTeachers() {
        return dao.findAll();
    }

    public void insertTeacher(MentorTeacher teacher) throws InsertException {
        dao.save(teacher);
    }

    public void removeTeacher(MentorTeacher teacher) throws DeleteException {
        dao.delete(teacher);
    }
    
    public void updateTeacher(MentorTeacher teacher) throws UpdateException{
        dao.update(teacher);
    }
    
    public List<User> getMentorTeacherByName(String name){
        return dao.getTeachersByName(name);
    }
    
}
