/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.model.project.TIDIRGroup;
import com.una.vdc.model.user.Student;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ulrik
 */
public class StudentDAO extends GenericDAO<Long, Student> {

    public StudentDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public void createPaGroup() {

    }

    public void inviteStudentsToGroup(List<Student> s, TIDIRGroup g) {
        et.begin();
        em.merge(s);
        em.merge(g);
        List<Student> students = getStudentsByGroup(g.getId());
        g.setStudents(students);
        for (Student student : students) {
            g.getStudents().add(student);
        }
        em.merge(g);
        et.commit();        
    }

    public List<Student> getStudentsByGroup(long idGroup) {
        Query q = em.createQuery("SELECT s FROM Student s JOIN s.tidirGroup t WHERE t.id = :tid ");
        q.setParameter("tid", idGroup);
        return q.getResultList();
    }

    public boolean checkIfStudentIsInGroup(Student s, TIDIRGroup g) {
        return true;
    }

}
