/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.persistence.dao;

import com.una.vdc.model.project.TIDIRGroup;
import com.una.vdc.model.user.Student;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ulrik
 */
public class StudentDAOTest {
    
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
     * Test of getStudentsByGroup method, of class StudentDAO.
     */
    @Test
    public void testGetStudentsByGroup() {
        TIDIRGroup g1 = new TIDIRGroup();
        g1.setCollegeClass(null);
        g1.setStudents(null);
    }

    /**
     * Test of checkIfStudentIsInGroup method, of class StudentDAO.
     */
    @Test
    public void testCheckIfStudentIsInGroup() {
    }
    
}
