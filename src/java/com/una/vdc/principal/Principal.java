/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.principal;

import com.una.vdc.bo.GroupController;
import com.una.vdc.bo.StudentController;
import com.una.vdc.exception.AssociationException;
import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.course.Course;
import com.una.vdc.model.course.Period;
import com.una.vdc.model.user.MentorTeacher;
import com.una.vdc.model.user.ModuleTeacher;
import com.una.vdc.persistence.DatabaseConnection;
import com.una.vdc.persistence.dao.CourseDAO;
import com.una.vdc.persistence.dao.PeriodDAO;
import com.una.vdc.persistence.dao.StudentDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/*
 1º Criar Curso
 2º Criar Periodo(s) para curso
 3º Criar turmas para periodo do curso
 4º A turma não pode estar contida em dois periodos(pois o periodo é somente de 1 curso em específico)

 */
/**
 *
 * @author Ulrik
 */
public class Principal {

    public void criarCursos() throws InsertException {
        EntityManager em = DatabaseConnection.instance().getManager();
        CourseDAO dao = new CourseDAO(em);
        Course ads = new Course();
        ads.setName("Análise e desenvolvimento de Sistemas");
        dao.save(ads);
        Course redes = new Course();
        redes.setName("Redes de Computadores");
        dao.save(redes);
        Course logistica = new Course();
        logistica.setName("Logistica");
        dao.save(logistica);
    }

    public void criarPeriodos() throws InsertException {
        EntityManager em = DatabaseConnection.instance().getManager();
        PeriodDAO pdao = new PeriodDAO(em);
        CourseDAO cdao = new CourseDAO(em);

        Period primeiroADS = new Period();
        primeiroADS.setPeriodDescription("1 Periodo - ADS");
        primeiroADS.setCourse(cdao.getById(1L));
        pdao.save(primeiroADS);

        Period quartoLogistica = new Period();
        quartoLogistica.setPeriodDescription("1 Perido - Redes");
        quartoLogistica.setCourse(cdao.getById(2L));
        pdao.save(quartoLogistica);
    }

    public void criarTurmas() {
        EntityManager em = DatabaseConnection.instance().getManager();
        EntityTransaction et = em.getTransaction();

        PeriodDAO pdao = new PeriodDAO(em);

        CollegeClass c1 = new CollegeClass();
        c1.setName("Turma A - 1 Periodo - ADS");
        c1.setPeriod(pdao.getById(1L));

        CollegeClass c2 = new CollegeClass();
        c2.setName("Turma B - 1 Periodo - Redes");
        c2.setPeriod(pdao.getById(2L));

        et.begin();
        em.merge(c1);
        em.merge(c2);
        et.commit();
    }

    public void criarProfessoresOrientadores() {
        EntityManager em = DatabaseConnection.instance().getManager();
        EntityTransaction et = em.getTransaction();
        MentorTeacher m1 = new MentorTeacher();
        m1.setName("mentor teacher 1");
        MentorTeacher m2 = new MentorTeacher();
        m2.setName("mentor teacher 2");
        MentorTeacher m3 = new MentorTeacher();
        m3.setName("mentor teacher 3");
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

    public static void main(String[] args) throws InsertException, UpdateException, AssociationException {
        EntityManager em = DatabaseConnection.instance().getManager();
     
        StudentDAO sdao = new StudentDAO(em);
        StudentController sc = new StudentController();
        GroupController gg = new GroupController();
        
        sdao.checkIfStudentIsInGroup(sc.getStudentById(1L), gg.getGroupById(1L));
        
        
    }
}
