/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.principal;

import com.una.vdc.dao.CollegeClassDAO;
import com.una.vdc.dao.TeacherDAO;
import com.una.vdc.model.CollegeClass;
import com.una.vdc.model.Teacher;
import com.una.vdc.persistencia.DatabaseConnection;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Ulrik
 */
public class Principal {

    public void criarProfessor(Teacher teacher) {
        EntityManager em = DatabaseConnection.instance().getManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(teacher);
        et.commit();
    }

    public void criarTurma(CollegeClass cc) {
        EntityManager em = DatabaseConnection.instance().getManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(cc);
        et.commit();
    }

    public static void main(String[] args) {
//        Principal p = new Principal();
        EntityManager em = DatabaseConnection.instance().getManager();
        
//        TeacherDAO tdao = new TeacherDAO(em);
//        CollegeClassDAO cdao = new CollegeClassDAO(em);

        /*
         Teacher prof1 = new Teacher("prof1");
         p.criarProfessor(prof1);
         Teacher prof2 = new Teacher("prof2");
         p.criarProfessor(prof2);
         Teacher prof3 = new Teacher("prof3");
         p.criarProfessor(prof3);
         Teacher prof4 = new Teacher("prof4");
         p.criarProfessor(prof4);
        
         CollegeClass turma1 = new CollegeClass("turma1");
         p.criarTurma(turma1);
         CollegeClass turma2 = new CollegeClass("turma2");
         p.criarTurma(turma2);
         CollegeClass turma3 = new CollegeClass("turma3");
         p.criarTurma(turma3);
         */
        
//        Teacher t1 = tdao.getById((long)1);
//        CollegeClass c1 = cdao.getById((long)1);
        
        
        
        
        
    }
}
