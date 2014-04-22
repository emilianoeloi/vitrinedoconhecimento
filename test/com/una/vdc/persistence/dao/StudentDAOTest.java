/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.persistence.DatabaseConnection;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ulrik
 */
public class StudentDAOTest {

    private StudentDAO sdao;

    public StudentDAOTest() {
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
        sdao = new StudentDAO(em);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createPaGroup method, of class StudentDAO.
     */
    @Test
    public void testCreatePaGroup() {
        
    }

    /**
     * Test of inviteStudentsToGroup method, of class StudentDAO.
     */
    @Test
    public void testInviteStudentsToGroup() {
                
        
    }

    /**
     * Test of getStudentsByProject method, of class StudentDAO.
     */
    @Test
    public void testGetStudentsByGroup() {

    }

    /**
     * Test of checkIfStudentIsInProject method, of class StudentDAO.
     */
    @Test
    public void testCheckIfStudentIsInGroup() {
    }

}
