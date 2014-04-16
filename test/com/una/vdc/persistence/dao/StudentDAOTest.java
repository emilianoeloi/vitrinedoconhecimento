/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.exception.InsertException;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.course.Course;
import com.una.vdc.model.course.Period;
import com.una.vdc.model.project.TIDIRGroup;
import com.una.vdc.persistence.DatabaseConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private GroupDAO gdao;
    private CollegeClassDAO ccdao;
    private CourseDAO cdao;
    private PeriodDAO pdao;

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
        gdao = new GroupDAO(em);
        ccdao = new CollegeClassDAO(em);
        cdao = new CourseDAO(em);
        pdao = new PeriodDAO(em);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createPaGroup method, of class StudentDAO.
     */
    @Test
    public void testCreatePaGroup() {
        TIDIRGroup g = new TIDIRGroup();
        
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

    }

    /**
     * Test of checkIfStudentIsInGroup method, of class StudentDAO.
     */
    @Test
    public void testCheckIfStudentIsInGroup() {
    }

}
