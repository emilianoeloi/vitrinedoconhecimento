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
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
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
        System.out.println("getAllOpenedTasks");
        TIDIRProject p = null;
        TaskDAO instance = null;
        List<Task> expResult = null;
        List<Task> result = instance.getAllOpenedTasks(p);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeTask method, of class TaskDAO.
     */
    @Test
    public void testCloseTask() throws Exception {
        System.out.println("closeTask");
        Task t = null;
        Student s = null;
        TaskDAO instance = null;
        instance.closeTask(t, s);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTasksByStudent method, of class TaskDAO.
     */
    @Test
    public void testGetTasksByStudent() {
        System.out.println("getTasksByStudent");
        Long idStudent = null;
        TaskDAO instance = null;
        List<Task> expResult = null;
        List<Task> result = instance.getTasksByStudent(idStudent);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTasksByStage method, of class TaskDAO.
     */
    @Test
    public void testGetTasksByStage() {
        System.out.println("getTasksByStage");
        Long idStage = null;
        TaskDAO instance = null;
        List<Task> expResult = null;
        List<Task> result = instance.getTasksByStage(idStage);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
