/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.dao;

import com.una.vdc.exception.InsertException;
import com.una.vdc.model.CollegeClass;
import com.una.vdc.model.Teacher;
import com.una.vdc.persistencia.DatabaseConnection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
            List<Teacher> teachers = getTeachersByCollegeClass((long) cclass.getID());
            if (!checkIfTeacherIsInClass(t, c)) {
                c.setTeacher(teachers);
                c.getTeacher().add(t);
                em.merge(c);
            }
            et.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Teacher> getTeachersByCollegeClass(long idClasse) {
        em = DatabaseConnection.instance().getManager();
        Query query = em.createQuery("SELECT t FROM Teacher t JOIN t.classes c WHERE c.id = :classe");
        query.setParameter("classe", idClasse);
        return query.getResultList();
    }

    public List<Teacher> getTeachersByName(String name) {
        em = DatabaseConnection.instance().getManager();
        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t WHERE t.name like :nome", Teacher.class);
        query.setParameter("nome", "%" + name + "%");
        return query.getResultList();

    }

    public boolean checkIfTeacherIsInClass(Teacher t, CollegeClass c) {
        List<Teacher> teachers;
        teachers = getTeachersByCollegeClass(c.getID());
        return teachers.contains(t);
    }

}
