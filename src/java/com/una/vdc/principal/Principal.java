/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.principal;

import com.una.vdc.dao.TeacherDAO;
import com.una.vdc.persistencia.DatabaseConnection;
import com.una.vdc.exception.InsertException;
import com.una.vdc.model.CollegeClass;
import com.una.vdc.model.Teacher;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ulrik
 */
public class Principal {

    public static void main(String[] args) {
        EntityManager em = DatabaseConnection.instance().getManager();

        TeacherDAO dao = new TeacherDAO(em);

        CollegeClass c = new CollegeClass("Turma 1");
        CollegeClass c2 = new CollegeClass("Turma 2");
        CollegeClass c3 = new CollegeClass("Turma 3");

        Teacher t = new Teacher("prof 1");

        try {
            dao.insertTeacherToClass(t, c);
            dao.insertTeacherToClass(t, c2);
            dao.insertTeacherToClass(t, c3);
            
        } catch (InsertException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
//
//        List<Teacher> teachers  = dao.getTeacherByClass(c2);
//        
//        for (Teacher teacher : teachers) {
//            JOptionPane.showMessageDialog(null, "Prof. :"+teacher.getNome());
//        }
    
    }
}
