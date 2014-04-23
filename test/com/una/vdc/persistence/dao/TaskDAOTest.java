/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.persistence.dao;

import com.una.vdc.model.project.TIDIRProject;
import com.una.vdc.model.project.Task;
import com.una.vdc.model.user.Student;
import com.una.vdc.persistence.DatabaseConnection;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ulrik
 */
public class TaskDAOTest {
    
    private TaskDAO tdao;
    
    public TaskDAOTest() {
    }
    
    @Before
    public void setUp() {
        EntityManager em = DatabaseConnection.instance().getManager();
        tdao = new TaskDAO(em);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllOpenedTasks method, of class TaskDAO.
     */
    @Test
    public void testGetAllOpenedTasks() {
    }

    /**
     * Test of closeTask method, of class TaskDAO.
     */
    @Test
    public void testCloseTask(){

    }

    /**
     * Test of getTasksByStudent method, of class TaskDAO.
     */
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
