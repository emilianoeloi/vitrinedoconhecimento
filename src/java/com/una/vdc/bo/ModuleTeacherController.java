/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.bo;

import com.una.vdc.exception.AssociationException;
import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.user.ModuleTeacher;
import com.una.vdc.persistence.DatabaseConnection;
import com.una.vdc.persistence.dao.ModuleTeacherDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author daniel
 */
public class ModuleTeacherController {
    
    private final ModuleTeacherDAO dao;

    public ModuleTeacherController() {
        EntityManager em = DatabaseConnection.instance().getManager();
        dao = new ModuleTeacherDAO(em);
    }
    
    public ModuleTeacher getTeacherById(Long id){
        return dao.getById(id);
    }
    
    public List<ModuleTeacher> getAllTeachers() {
        return dao.findAll();
    }

    public void insertTeacher(ModuleTeacher teacher) throws InsertException {
        dao.save(teacher);
    }

    public void removeTeacher(ModuleTeacher teacher) throws UpdateException {
        dao.delete(teacher);
    }

    public void updateTeacher(ModuleTeacher teacher) throws UpdateException{
        dao.update(teacher);
    }
    
    public void associateModuleTeacherToClass(ModuleTeacher m, CollegeClass cclass) throws AssociationException{
        dao.associateModuleTeacherToClass(m, cclass);
    }
    
    public List<ModuleTeacher> getModuleTeachersByCollegeClass(long idClasse){
        return dao.getModuleTeachersByCollegeClass(idClasse);
    }
    
    public List<ModuleTeacher> getModuleTeachersByName(String name){
        return dao.getTeachersByName(name);
    }
    
}
