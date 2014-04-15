/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.exception.AssociationException;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.user.ModuleTeacher;
import com.una.vdc.persistence.DatabaseConnection;
import java.util.ArrayList;
import java.util.List;
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
 * @author daniel
 */
public class ModuleTeacherDAOTest {

    EntityManager em = DatabaseConnection.instance().getManager();
    ModuleTeacherDAO mDao = new ModuleTeacherDAO(em);
    CollegeClassDAO cDao = new CollegeClassDAO(em);

    public ModuleTeacherDAOTest() {
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
     * Test of getTeachersByCollegeClass method, of class ModuleTeacherDAO.
     */
    @Test
    public void testGetModuleTeachersByCollegeClass() {
        ModuleTeacher m = mDao.getById(2L);
        CollegeClass c1 = cDao.getById(1L);
        long idClasse = c1.getId();
        List<ModuleTeacher> expResult = new ArrayList<>();
        expResult.add(m);
        List<ModuleTeacher> result = mDao.getModuleTeachersByCollegeClass(idClasse);

        assertEquals(expResult, result);
    }

    /**
     * Test of associateModuleTeacherToClass method, of class ModuleTeacherDAO.
     */
    @Test
    public void testAssociateModuleTeacherToClass() {
        ModuleTeacher mt = mDao.getById(3L);
        CollegeClass cc = cDao.getById(3L);
        
        try {
            mDao.associateModuleTeacherToClass(mt, cc);
        } catch (AssociationException ex) {
            Logger.getLogger(ModuleTeacherDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<ModuleTeacher> teachers = mDao.getModuleTeachersByCollegeClass(3L);

        assertTrue(teachers.contains(mt));
    }

    /**
     * Test of getTeachersByName method, of class ModuleTeacherDAO.
     */
    @Test
    public void testGetTeachersByName(){
        List<ModuleTeacher> teachersExpected = new ArrayList<>();
        teachersExpected.add(mDao.getById(1L));
        
        List<ModuleTeacher> teachersActual = mDao.getTeachersByName("module teacher 1");
        
        assertEquals(teachersExpected, teachersActual);
    }
}
