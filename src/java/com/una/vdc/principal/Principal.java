/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.principal;

import com.una.vdc.dao.TeacherDAO;
import com.una.vdc.model.CollegeClass;
import com.una.vdc.model.Teacher;
import com.una.vdc.persistencia.DatabaseConnection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;

/**
 *
 * @author Ulrik
 */
public class Principal {

    public void criarProfessores() {
        EntityManager em = DatabaseConnection.instance().getManager();
        EntityTransaction et = em.getTransaction();
        Teacher teacher1 = new Teacher("Professor 1");
        Teacher teacher2 = new Teacher("Professor 2");
        Teacher teacher3 = new Teacher("Professor 3");

        et.begin();
        em.merge(teacher1);
        em.merge(teacher2);
        em.merge(teacher3);
        et.commit();

    }

    public void criarTurmas() {
        EntityManager em = DatabaseConnection.instance().getManager();
        EntityTransaction et = em.getTransaction();
        CollegeClass c1 = new CollegeClass("Turma 1");
        CollegeClass c2 = new CollegeClass("Turma 2");
        CollegeClass c3 = new CollegeClass("Turma 3");
        et.begin();
        em.merge(c1);
        em.merge(c2);
        em.merge(c3);
        et.commit();
    }

    public static void main(String[] args) {
        Principal p = new Principal();
        EntityManager em = DatabaseConnection.instance().getManager();

        TeacherDAO tdao = new TeacherDAO(em);
        
        List<Teacher> teachers = tdao.findAll();
        
        for (Teacher teacher : teachers) {
            JOptionPane.showMessageDialog(null, teacher);
        }
        
    }
}
