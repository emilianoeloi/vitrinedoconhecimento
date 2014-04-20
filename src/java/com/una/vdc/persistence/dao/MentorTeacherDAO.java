/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.exception.AssociationException;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.user.MentorTeacher;
import com.una.vdc.model.user.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ulrik
 */
public class MentorTeacherDAO extends GenericDAO<Long, MentorTeacher> implements ITeacher {

    public MentorTeacherDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void associateTeacherToClass(User teacher, CollegeClass cclass) throws AssociationException {
        try {
            et.begin();
            cclass.setMentorTeacher((MentorTeacher) teacher);
            em.merge(teacher);
            em.merge(cclass);
            et.commit();

        } catch (Exception e) {
            et.rollback();
            throw new AssociationException(e.getMessage());
        }

    }

    public MentorTeacher getMentorTeacherByClass(long idClass) {
        et.begin();
        Query query = em.createQuery("SELECT t FROM MentorTeacher t JOIN t.collegeClass c WHERE c.id = :mid");
        query.setParameter("mid", idClass);
        return (MentorTeacher) query.getSingleResult();
    }

    @Override
    public List<User> getTeachersByName(String name) {
        Query query = em.createQuery("SELECT t FROM MentorTeacher t WHERE t.name like :n");
        query.setParameter("n", "%" + name + "%");
        return query.getResultList();
    }

}
