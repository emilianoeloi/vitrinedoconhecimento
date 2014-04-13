/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.exception.AssociationException;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.user.MentorTeacher;
import com.una.vdc.model.user.User;
import com.una.vdc.persistence.DatabaseConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MentorTeacherDAOTest {

    private MentorTeacherDAO dao;
    private CollegeClassDAO cdao;

    public MentorTeacherDAOTest() {
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
        dao = new MentorTeacherDAO(em);
        cdao = new CollegeClassDAO(em);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of associateMentorTeacherToClass method, of class MentorTeacherDAO.
     */
    @Test
    public void testAssociateMentorTeacherToClass() {
        User teacher = dao.getById(6L);
        CollegeClass cclass = cdao.getById(1L);

        try {
            dao.associateTeacherToClass(teacher, cclass);
        } catch (AssociationException ex) {
            Logger.getLogger(MentorTeacherDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertNotNull(cclass.getMentorTeacher());
    }

    @Test
    public void testGetTeacherByClass() {
        User teacher = dao.getTeacherByClass(2L);        
        String expName = "mentor teacher 1";        
        assertEquals(expName, teacher.getName());        
    }

}
