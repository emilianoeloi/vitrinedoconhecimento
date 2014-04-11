/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.exception.AssociationException;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.user.ModuleTeacher;
import com.una.vdc.persistence.DatabaseConnection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author daniel
 */
public class ModuleTeacherDAO extends GenericDAO<Long, ModuleTeacher> {

    public ModuleTeacherDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
    public void associateModuleTeacherToClass(ModuleTeacher m, CollegeClass cclass) throws AssociationException {
        try {
            et.begin();
            ModuleTeacher t = em.merge(m);
            CollegeClass c = em.merge(cclass);
            List<ModuleTeacher> teachers = getModuleTeachersByCollegeClass((long) cclass.getID());
            if (!checkIfTeacherIsInClass(t, c)) {
                c.setModuleTeacher(teachers);
                c.getModuleTeacher().add(t);
                em.merge(c);
            }
            et.commit();
        } catch (Exception e) {
            throw new AssociationException(e.getMessage());
        }
    }
    
    
    public List<ModuleTeacher> getModuleTeachersByCollegeClass(long idClasse) {
        em = DatabaseConnection.instance().getManager();
        Query query = em.createQuery("SELECT t FROM ModuleTeacher t JOIN t.collegeClass c WHERE c.id = :classe");
        query.setParameter("classe", idClasse);
        return query.getResultList();
    }
    
    
    public List<ModuleTeacher> getTeachersByName(String name) {
        em = DatabaseConnection.instance().getManager();
        TypedQuery<ModuleTeacher> query = em.createQuery("SELECT t FROM ModuleTeacher t WHERE t.name like :n", ModuleTeacher.class);
        query.setParameter("n", "%" + name + "%");
        return query.getResultList();

    }
        
    public boolean checkIfTeacherIsInClass(ModuleTeacher t, CollegeClass c) {
        List<ModuleTeacher> teachers;
        teachers = getModuleTeachersByCollegeClass(c.getID());
        return teachers.contains(t);
    }
    
}
