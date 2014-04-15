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

    public void createCourses() {
        Course course1 = new Course("ADS");
        Course course2 = new Course("REDES");
        Course course3 = new Course("LOGISTICA");
        try {
            cdao.save(course1);
            cdao.save(course2);
            cdao.save(course3);
        } catch (InsertException ex) {
            Logger.getLogger(StudentDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createPeriods() {
        Period p1 = new Period("1P_ADS", cdao.getById(1L));
        Period p2 = new Period("1P_REDES", cdao.getById(2L));
        Period p3 = new Period("1P_LOGISTICA", cdao.getById(3L));

        try {
            pdao.save(p1);
            pdao.save(p2);
            pdao.save(p3);
        } catch (InsertException ex) {
            Logger.getLogger(StudentDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createClasses() {
        CollegeClass c1 = new CollegeClass();
        c1.setName("Turma A");
        c1.setPeriod(pdao.getById(1L));
        CollegeClass c2 = new CollegeClass();
        c2.setName("Turma A");
        c2.setPeriod(pdao.getById(1L));
        CollegeClass c3 = new CollegeClass();
        c3.setName("Turma A");
        c3.setPeriod(pdao.getById(1L));
        
        try {
            ccdao.save(c1);
            ccdao.save(c2);
            ccdao.save(c3);
        } catch (InsertException ex) {
            Logger.getLogger(StudentDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Test of createPaGroup method, of class StudentDAO.
     */
    @Test
    public void testCreatePaGroup() {
        DatabaseConnection.instance().getManager();
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
