/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.exception.InsertException;
import com.una.vdc.model.project.TIDIRGroup;
import com.una.vdc.model.user.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ulrik
 */
public class StudentDAO extends GenericDAO<Long, Student> {

    private final GroupDAO dao = new GroupDAO(em);
    
    public StudentDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public void createPaGroup(TIDIRGroup g) {
        try {
            dao.save(g);
        } catch (InsertException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
