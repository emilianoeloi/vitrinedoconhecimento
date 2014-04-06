/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.dao;

import com.una.vdc.persistencia.DatabaseConnection;
import com.una.vdc.exception.InsertException;
import com.una.vdc.model.CollegeClass;
import com.una.vdc.model.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ulrik
 */
public class TeacherDAO extends GenericDAO<Long, Teacher> {

    
    public TeacherDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public void associateTeacherToClass(Teacher teacher, CollegeClass cclass) throws InsertException {
        try {
            em = DatabaseConnection.instance().getManager();
            et = em.getTransaction();
            et.begin();
            
            Teacher t = em.merge(teacher);
            CollegeClass c = em.merge(cclass);
            
            cclass.setTeacher(new ArrayList<Teacher>());
            cclass.getTeacher().add(t);
            
            em.merge(c);
            
            et.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Teacher> getTeacherByClass(long idClasse) {
        em = DatabaseConnection.instance().getManager();

        Query query = em.createQuery("SELECT t FROM Teacher t JOIN t.classes c WHERE c.id = :classe");
        query.setParameter("classe", idClasse);
        
        return query.getResultList();
    }

}
