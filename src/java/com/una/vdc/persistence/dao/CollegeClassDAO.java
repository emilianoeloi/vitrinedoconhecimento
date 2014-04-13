/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.model.course.CollegeClass;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ulrik
 */
public class CollegeClassDAO extends GenericDAO<Long, CollegeClass> {

    public CollegeClassDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public List<CollegeClass> getCollegeClassesByCourse(long idCourse) {
        Query query = em.createQuery("SELECT c FROM CollegeClass c JOIN c.period.course cc WHERE cc.ID = :course");
        query.setParameter("course", idCourse);
        return query.getResultList();
    }

}
