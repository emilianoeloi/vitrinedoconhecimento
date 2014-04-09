/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.persistence.dao;

import com.una.vdc.model.project.TIDIRGroup;
import javax.persistence.EntityManager;

/**
 *
 * @author daniel
 */
public class GroupDAO extends GenericDAO<Long, TIDIRGroup>{

    public GroupDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
