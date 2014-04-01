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
import java.util.Arrays;
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

    public void insertTeacherToClass(Teacher teacher, CollegeClass cclass) throws InsertException {
        try {
            em = DatabaseConnection.instance().getManager();
            et = em.getTransaction();
            et.begin();
            teacher.validade();
            cclass.validade();
            em.persist(teacher);
            em.persist(cclass);
            em.flush();
            List<Teacher> teachers = new ArrayList<>();
            teachers.add(teacher);
            cclass.setProfessor(teachers);
            em.merge(cclass);
            em.flush();
            et.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public List<Teacher> getTeacherByClass(CollegeClass cclass) {
        em = DatabaseConnection.instance().getManager();

        Query query = em.createQuery("FROM CollegeClass c WHERE c.teachers =: ");
        query.setParameter("teacher", cclass);

        
        
        return query.getResultList();

    }

}
