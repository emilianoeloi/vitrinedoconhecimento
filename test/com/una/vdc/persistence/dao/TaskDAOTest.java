/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.StudentNotInGroupException;
import com.una.vdc.model.project.TIDIRProject;
import com.una.vdc.model.project.Task;
import com.una.vdc.model.user.Student;
import com.una.vdc.persistence.DatabaseConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Ulrik
 */
public class TaskDAOTest {

    private TaskDAO tdao;
    private StudentDAO sdao;
    private TaskSituationDAO tsdao;

    public TaskDAOTest() {
    }

    @Before
    public void setUp() {
        EntityManager em = DatabaseConnection.instance().getManager();
        sdao = new StudentDAO(em);
        tdao = new TaskDAO(em);
        tsdao = new TaskSituationDAO(em);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllClosedTasksByProject method, of class TaskDAO.
     */
    @Test
    @Ignore
    public void getAllClosedTasksByProject() {
        try {
            tdao.closeTask(tdao.getById(3L), sdao.getById(9L));
            tdao.closeTask(tdao.getById(1L), sdao.getById(10L));
            tdao.closeTask(tdao.getById(2L), sdao.getById(8L));
        } catch (InsertException ex) {
            Logger.getLogger(TaskDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (StudentNotInGroupException ex) {
            Logger.getLogger(TaskDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Task> actualTasksOpened = tdao.getAllClosedTasksByProject(sdao.getById(8L).getTidirProject());
        List<Task> expTasks = new ArrayList<>();
        expTasks.add(tdao.getById(2L));
        assertEquals(expTasks, actualTasksOpened);
   }

    /**
     * Test of closeTask method, of class TaskDAO.
     */
    @Ignore
    @Test
    public void testCloseTask() {
        try {
            tdao.closeTask(tdao.getById(3L), sdao.getById(9L));
        } catch (InsertException ex) {
            Logger.getLogger(TaskDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (StudentNotInGroupException ex) {
            Logger.getLogger(TaskDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //assertEquals(tsdao.getById(2L).getTask(), tdao.getById(1L));
    }

    @Test
    public void testGetAllOpenedTasks(){
        List<Task> openTasks = tdao.getAllOpenTasksByGroup(sdao.getById(8L).getTidirProject());
        for (Task task : openTasks) {
            JOptionPane.showMessageDialog(null, task.getDescTask());
        }
    }
    
    
    /**
     * Test of getTasksByStudent method, of class TaskDAO.
     */
    @Ignore
    @Test
    public void testGetTasksByStudent() {
    }

    /**
     * Test of getTasksByStage method, of class TaskDAO.
     */
    @Test
    public void testGetTasksByStage() {
        List<Task> actualTasks = tdao.getTasksByStage(4L);
        List<Task> expTasks = new ArrayList<>();
        expTasks.add(tdao.getById(3L));
        assertEquals(expTasks, actualTasks);
    }

}
