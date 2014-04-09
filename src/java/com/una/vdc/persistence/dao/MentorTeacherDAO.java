/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.exception.InsertException;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.user.MentorTeacher;
import com.una.vdc.persistence.DatabaseConnection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ulrik
 */
public class MentorTeacherDAO extends GenericDAO<Long, MentorTeacher> {

    public MentorTeacherDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public void associateTeacherToClass(MentorTeacher teacher, CollegeClass cclass) throws InsertException {

    }

//    public List<MentorTeacher> getTeachersByCollegeClass(long idClasse) {
//        em = DatabaseConnection.instance().getManager();
//        Query query = em.createQuery("SELECT t FROM Teacher t JOIN t.classes c WHERE c.id = :classe");
//        query.setParameter("classe", idClasse);
//        return query.getResultList();
//    }

//    public List<MentorTeacher> getTeachersByName(String name) {
//        em = DatabaseConnection.instance().getManager();
//        TypedQuery<MentorTeacher> query = em.createQuery("SELECT t FROM Teacher t WHERE t.name like :nome", MentorTeacher.class);
//        query.setParameter("nome", "%" + name + "%");
//        return query.getResultList();
//
//    }
//
//    public boolean checkIfTeacherIsInClass(MentorTeacher t, CollegeClass c) {
//        List<MentorTeacher> teachers;
//        teachers = getTeachersByCollegeClass(c.getID());
//        return teachers.contains(t);
//    }

}