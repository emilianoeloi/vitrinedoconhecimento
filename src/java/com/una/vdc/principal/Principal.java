/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.principal;

import com.una.vdc.persistence.dao.MentorTeacherDAO;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.user.MentorTeacher;
import com.una.vdc.model.user.ModuleTeacher;
import com.una.vdc.persistence.DatabaseConnection;
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
//        Principal p = new Principal();
        EntityManager em = DatabaseConnection.instance().getManager();
//        em.getTransaction().begin();
//        
//        MentorTeacher mt = new MentorTeacher();
//        mt.setName("prof mentor 1");
//        em.merge(mt);
//        
//        ModuleTeacher mm = new ModuleTeacher();
//        mm.setName("prof module 1");
//        em.merge(mm);
//        
//        em.getTransaction().commit();
//
//        MentorTeacherDAO tdao = new MentorTeacherDAO(em);
//        
//        List<Teacher> profs = tdao.getTeachersByName("p");
//        for (Teacher teacher : profs) {
//            System.out.println(teacher.getNome());
//        }
    }
}
