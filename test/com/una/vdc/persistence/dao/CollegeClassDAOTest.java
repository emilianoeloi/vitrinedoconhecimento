/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.persistence.dao;

import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.persistence.DatabaseConnection;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ulrik
 */
public class CollegeClassDAOTest {
    
    private CollegeClassDAO dao;
    private CourseDAO cdao;
    private PeriodDAO pdao;
    
    public CollegeClassDAOTest() {
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
        dao = new CollegeClassDAO(em);
        cdao = new CourseDAO(em);
        pdao = new PeriodDAO(em);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCollegeClassesByCourse method, of class CollegeClassDAO.
     */
    @Test
    public void testGetCollegeClassesByCourse() {
        List<CollegeClass> expResult = new ArrayList<>();
        expResult.add(dao.getById(1L));        
        assertEquals(expResult, dao.getCollegeClassesByCourse(1L));
    }

    /**
     * Test of getCollegeClassesByName method, of class CollegeClassDAO.
     */
    @Test
    public void testGetCollegeClassesByName() {
        List<CollegeClass> expResult = new ArrayList<>();
        expResult.add(dao.getById(1L));
        
        List<CollegeClass> actualRes = dao.getCollegeClassesByName("ADS", 1L);
        
        assertEquals(expResult, actualRes);
    }
       
}
