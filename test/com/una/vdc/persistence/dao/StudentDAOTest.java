/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.exception.UpdateException;
import com.una.vdc.model.user.Student;
import com.una.vdc.persistence.DatabaseConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ulrik
 */
public class StudentDAOTest {

    private StudentDAO sdao;
    private ProjectDAO pdao;

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
        pdao = new ProjectDAO(em);
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
     * Test of insertStudentsToGroup method, of class StudentDAO.
     */
    @Test
    public void testInviteStudentsToGroup() {                
        Student s = sdao.getById(6L);
        Student s2 = sdao.getById(7L);
        Student s3 = sdao.getById(8L);
        
        List<Student> ls = new ArrayList<>();
        ls.add(s);
        ls.add(s2);
        ls.add(s3);
                
        try {            
            sdao.insertStudentsToGroup(ls, pdao.getById(1L));
        } catch (UpdateException ex) {
            Logger.getLogger(StudentDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Assert.assertEquals(ls, sdao.getStudentsByProject(1L));
        
    }

    /**
     * Test of getStudentsByProject method, of class StudentDAO.
     */
    @Test
    public void testGetStudentsByProject() {
        List<Student> actualStudents = sdao.getStudentsByProject(1);
        List<Student> expStudents = new ArrayList<>();
        expStudents.add(sdao.getById(7L));
        expStudents.add(sdao.getById(8L));
        expStudents.add(sdao.getById(9L));
        Assert.assertEquals(expStudents, actualStudents);
    }

    /**
     * Test of checkIfStudentIsInProject method, of class StudentDAO.
     */
    @Test
    public void testCheckIfStudentIsInGroup() {
        Assert.assertFalse(sdao.checkIfStudentIsInProject(sdao.getById(7L), pdao.getById(2L)));
        Assert.assertTrue(sdao.checkIfStudentIsInProject(sdao.getById(8L), pdao.getById(2L)));
    }

}
