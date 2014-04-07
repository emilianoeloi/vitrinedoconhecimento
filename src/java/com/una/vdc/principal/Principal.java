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
//        Principal p = new Principal();
        EntityManager em = DatabaseConnection.instance().getManager();
        Principal p = new Principal();
        p.criarProfessores();
        p.criarTurmas();
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
