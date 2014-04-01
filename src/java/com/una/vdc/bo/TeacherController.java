/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

import com.una.vdc.dao.TeacherDAO;
import com.una.vdc.persistencia.DatabaseConnection;
import com.una.vdc.exception.InsertException;
import com.una.vdc.model.CollegeClass;
import com.una.vdc.model.Teacher;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class TeacherController {
    
    
    public TeacherController(){
    }

    public void associateTeacherToClass(Teacher teacher, CollegeClass cclass) {
    }

}
