/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.principal;

import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.user.MentorTeacher;
import com.una.vdc.model.user.ModuleTeacher;
import com.una.vdc.persistence.DatabaseConnection;
import com.una.vdc.persistence.dao.ModuleTeacherDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Ulrik
 */
public class Principal {

    public void criarProfessoresOrientadores() {
        EntityManager em = DatabaseConnection.instance().getManager();
        EntityTransaction et = em.getTransaction();
        MentorTeacher m1 = new MentorTeacher();
        m1.setName("module teacher 1");
        MentorTeacher m2 = new MentorTeacher();
        m2.setName("module teacher 2");
        MentorTeacher m3 = new MentorTeacher();
        m3.setName("module teacher 3");
        et.begin();
        em.merge(m1);
        em.merge(m2);
        em.merge(m3);
        et.commit();
    }

    public void criarProfessoresModulo() {
        EntityManager em = DatabaseConnection.instance().getManager();
        EntityTransaction et = em.getTransaction();
        ModuleTeacher m1 = new ModuleTeacher();
        m1.setName("module teacher 1");
        ModuleTeacher m2 = new ModuleTeacher();
        m2.setName("module teacher 2");
        ModuleTeacher m3 = new ModuleTeacher();
        m3.setName("module teacher 3");
        et.begin();
        em.merge(m1);
        em.merge(m2);
        em.merge(m3);
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

    public static void main(String[] args) throws InsertException, UpdateException {
        Principal p = new Principal();
        EntityManager em = DatabaseConnection.instance().getManager();

//        p.criarProfessoresModulo();
//        p.criarTurmas();
        ModuleTeacherDAO dao = new ModuleTeacherDAO(em);

        ModuleTeacher a = dao.getById(2L);
        
        a.setName("aaa");
        
        
        
        dao.update(a);
        
        dao.delete(a);
        
//        ModuleTeacher a = dao.getById(2L);
//        dao.delete(a);

    }
}
