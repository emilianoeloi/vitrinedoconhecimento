<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.persistence.dao;

import com.una.vdc.exception.InsertException;
import com.una.vdc.model.project.TIDIRStage;
import javax.persistence.EntityManager;

/**
 *
 * @author daniel
 */
public class TIDIRStageDAO extends GenericDAO<Long, TIDIRStage>{

    public TIDIRStageDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.persistence.dao;

import com.una.vdc.exception.InsertException;
import com.una.vdc.model.project.TIDIRStage;
import javax.persistence.EntityManager;

/**
 *
 * @author daniel
 */
public class TIDIRStageDAO extends GenericDAO<Long, TIDIRStage>{

    public TIDIRStageDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
>>>>>>> 613f669a22e9b2b6f8de3f0a0dce662163a3a277
