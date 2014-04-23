/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.persistence.dao;

import com.una.vdc.model.project.TIDIRStage;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author daniel
 */
public class StageDAO extends GenericDAO<Long, TIDIRStage>{

    public StageDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
    public List<TIDIRStage> getStagesByCourse(Long idCourse){
        TypedQuery<TIDIRStage> query = em.createQuery("SELECT t FROM TIDIRStage t WHERE t.course.id = :id", TIDIRStage.class);
        query.setParameter("id", idCourse);
        return query.getResultList();
    }
    
}
