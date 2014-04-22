/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.persistence.dao;

import com.una.vdc.exception.InsertException;
import com.una.vdc.model.project.Status;
import com.una.vdc.model.project.Task;
import com.una.vdc.model.project.TaskSituation;
import com.una.vdc.model.user.Student;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class TaskDAO extends GenericDAO<Long, Task>{

    private final TaskSituationDAO tdao;
    
    public TaskDAO(EntityManager entityManager) {
        super(entityManager);
        tdao = new TaskSituationDAO(entityManager);
    }
    
    public void closeTask(Task t, Student s) throws InsertException{
        TaskSituation ts = new TaskSituation(Status.FINALIZED);
        ts.setTask(t);
        ts.setStudent(s);
        ts.setEndDate(new GregorianCalendar());
        tdao.save(ts);        
    }
    
}
