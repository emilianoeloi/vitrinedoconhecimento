/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.user.MentorTeacher;
import com.una.vdc.model.user.ModuleTeacher;
import com.una.vdc.persistence.DatabaseConnection;
import com.una.vdc.services.TeacherService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author daniel
 */
public class ModuleTeacherDAO extends GenericDAO<Long, ModuleTeacher> {

    public ModuleTeacherDAO(EntityManager entityManager) {
        super(entityManager);
    }
    /*
    public void associateModuleTeacherToClass(ModuleTeacher m, CollegeClass cclass) {
        try {
            et = em.getTransaction();
            et.begin();
            ModuleTeacher t = em.merge(m);
            CollegeClass c = em.merge(cclass);
            List<ModuleTeacher> teachers = getTeachersByCollegeClass((long) cclass.getID());
            if (!checkIfTeacherIsInClass(t, c)) {
                c.setMentorTeacher(teachers);
                c.getTeacher().add(t);
                em.merge(c);
            }
            et.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    */
    /*
    public List<MentorTeacher> getTeachersByCollegeClass(long idClasse) {
        em = DatabaseConnection.instance().getManager();
        Query query = em.createQuery("SELECT t FROM Teacher t JOIN t.classes c WHERE c.id = :classe");
        query.setParameter("classe", idClasse);
        return query.getResultList();
    }
    */
    /*
    public List<MentorTeacher> getTeachersByName(String name) {
        em = DatabaseConnection.instance().getManager();
        TypedQuery<MentorTeacher> query = em.createQuery("SELECT t FROM Teacher t WHERE t.name like :nome", MentorTeacher.class);
        query.setParameter("nome", "%" + name + "%");
        return query.getResultList();

    }
    */
    /*
    public boolean checkIfTeacherIsInClass(MentorTeacher t, CollegeClass c) {
        List<MentorTeacher> teachers;
        teachers = getTeachersByCollegeClass(c.getID());
        return teachers.contains(t);
    }
    */
}
