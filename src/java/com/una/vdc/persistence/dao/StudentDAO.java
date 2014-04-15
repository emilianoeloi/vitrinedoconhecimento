/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.model.project.TIDIRGroup;
import com.una.vdc.model.user.Student;
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

    public void inviteStudentsToGroup(List<Student> students, TIDIRGroup g) {
        List<Student> studentsInGroup = getStudentsByGroup(g.getId());
        et.begin();
        em.merge(students);
        em.merge(g);

        for (Student student : students) {
            if (!checkIfStudentIsInGroup(student, g)) {
                studentsInGroup.add(student);
            }
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
        List<Student> studentsInGroup = getStudentsByGroup(g.getId());
        return studentsInGroup.contains(s);
    }

}
