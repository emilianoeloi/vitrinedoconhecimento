/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.bo;

import com.una.vdc.exception.DeleteException;
import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.StudentNotInGroupException;
import com.una.vdc.exception.UpdateException;
import com.una.vdc.model.project.TIDIRProject;
import com.una.vdc.model.project.TIDIRStage;
import com.una.vdc.model.project.Task;
import com.una.vdc.model.user.Student;
import com.una.vdc.persistence.DatabaseConnection;
import com.una.vdc.persistence.dao.TaskDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class TaskController {
    
    private final TaskDAO dao;

    public TaskController() {
        EntityManager em = DatabaseConnection.instance().getManager();
        dao = new TaskDAO(em);
    }
    
    public List<Task> getAllClosedTasksByProject(TIDIRProject p){
        return dao.getAllClosedTasksByProject(p);
    }
    
    public List<Task> getAllOpenTasksByGroup(TIDIRProject p){
        return dao.getAllOpenTasksByGroup(p);
    }
    
    public List<Task> getClosedTasksByStudent(Long idStudent){
        return dao.getClosedTasksByStudent(idStudent);
    }
    
    public void closeTask(Task t, Student s) throws InsertException, StudentNotInGroupException{
        dao.closeTask(t, s);
    }
    
    public List<Task> getTasksByStage(TIDIRStage stage) {
        return dao.getTasksByStage(stage);
    }
    
    public Task getTaskById(Long id) {
        return dao.getById(id);
    }

    public List<Task> getAllTasks() {
        return dao.findAll();
    }

    public void insertTask(Task t) throws InsertException {
        dao.save(t);
    }

    public void removeTask(Task t) throws DeleteException {
        dao.delete(t);
    }

    public void updateTask (Task t) throws UpdateException {
        dao.update(t);
    }
    
}
