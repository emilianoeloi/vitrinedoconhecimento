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
import javax.persistence.TypedQuery;

/**
 *
 * @author Ulrik
 */
public class CollegeClassDAO extends GenericDAO<Long, CollegeClass> {
    
    private static final String JPQL_GET_COLLEGECLASSES_BY_COURSE = "SELECT c FROM CollegeClass c JOIN c.period.course cc WHERE cc.id = :course";

    public CollegeClassDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public List<CollegeClass> getCollegeClassesByCourse(long idCourse) {
        Query query = em.createQuery(JPQL_GET_COLLEGECLASSES_BY_COURSE);
        query.setParameter("course", idCourse);
        return query.getResultList();
    }
    
    public List<CollegeClass> getCollegeClassesByName(CollegeClass collegeClass) {
        StringBuilder jpql = new StringBuilder();
        jpql.append(JPQL_GET_COLLEGECLASSES_BY_COURSE);
        jpql.append(" AND c.name like :name");
        TypedQuery<CollegeClass> query = em.createQuery(jpql.toString(), CollegeClass.class);
        query.setParameter("course", collegeClass.getPeriod().getCourse().getId());
        query.setParameter("name", "%" + collegeClass.getName() + "%");
        return query.getResultList();

    }

}
