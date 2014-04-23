/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.StudentNotInGroupException;
import com.una.vdc.model.project.Status;
import com.una.vdc.model.project.TIDIRProject;
import com.una.vdc.model.project.TIDIRStage;
import com.una.vdc.model.project.Task;
import com.una.vdc.model.project.TaskSituation;
import com.una.vdc.model.user.Student;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ulrik
 */
public class TaskDAO extends GenericDAO<Long, Task> {
    
    private final TaskSituationDAO tdao;
    
    public TaskDAO(EntityManager entityManager) {
        super(entityManager);
        tdao = new TaskSituationDAO(entityManager);
    }
    
    private List<TaskSituation> getTasksInTaskSituation(TIDIRProject p) {
        Query query = em.createQuery("SELECT ts FROM TaskSituation ts WHERE ts.student.tidirProject = :project");
        query.setParameter("project", p);
        return query.getResultList();
    }
    
    public List<Task> getAllClosedTasksByProject(TIDIRProject p) {
        List<TaskSituation> tasksInTasksSituation = getTasksInTaskSituation(p);
        List<Task> closedTasks = new ArrayList<>();
        for (TaskSituation taskSituation : tasksInTasksSituation) {
            closedTasks.add(taskSituation.getTask());
        }
        return closedTasks;
    }

    public List<Task> getAllOpenTasksByGroup(TIDIRProject p) {
        List<Task> allTasks = findAll();
        List<Task> closedTasks = getAllClosedTasksByProject(p);        
        for (Task task : closedTasks) {
            if (allTasks.contains(task)) {
                allTasks.remove(task);
            }
        }        
        return allTasks;
    }
    
    private List<TaskSituation> getTasksSituationByStudent(Long idStudent) {
        Query query = em.createQuery("SELECT t FROM TaskSituation t JOIN t.student tc WHERE tc.id = :id");
        query.setParameter("id", idStudent);
        return query.getResultList();
    }
    
    public List<Task> getClosedTasksByStudent(Long idStudent) {
        List<TaskSituation> ts = getTasksSituationByStudent(idStudent);
        List<Task> tasks = new ArrayList<>();
        for (TaskSituation taskSituation : ts) {
            tasks.add(taskSituation.getTask());
        }
        return tasks;
    }
    
    public void closeTask(Task t, Student s) throws InsertException, StudentNotInGroupException {        
        if (s.getTidirProject() == null) {
            throw new StudentNotInGroupException();
        }
        TaskSituation ts = new TaskSituation();
        ts.setStatus(Status.FINALIZED);
        ts.setTask(t);
        ts.setStudent(s);
        ts.setProject(s.getTidirProject());
        ts.setEndDate(new GregorianCalendar());
        tdao.save(ts);
    }
    
    public List<Task> getTasksByStage(TIDIRStage stage) {
        Query query = em.createQuery("SELECT t FROM Task t WHERE t.tidirStage = :s");
        query.setParameter("s", stage);
        return query.getResultList();
    }
    
}
