/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.bo;

import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.project.TIDIRProject;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author emilianoeloi
 */
public class ProjectControllerTest {
    
    private static ProjectController projectCtrl;
    private static CollegeClassController collegeClassCtrl;
    
    public ProjectControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        projectCtrl = new ProjectController();
        collegeClassCtrl = new CollegeClassController();
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

    @Test
    public void testGetProjectsByName() {
    }

    @Test
    public void testGetProjectById() {
    }

    @Test
    public void testGetAllProjects() {
    }

    @Test
    public void testInsertProject() throws Exception {
        
        TIDIRProject project = new TIDIRProject();
        project.setProjectName("Vitrine do Conhecimento");
        project.setCollegeClass(collegeClassCtrl.getCollegeClassById(2L));
        
        projectCtrl.insertProject(project);
        
    }

    @Test
    public void testRemoveProject() throws Exception {
    }

    @Test
    public void testUpdateProject() throws Exception {
    }
    
}
