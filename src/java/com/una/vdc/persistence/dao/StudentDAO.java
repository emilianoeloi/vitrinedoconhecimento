/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.exception.UpdateException;
import com.una.vdc.model.project.TIDIRProject;
import com.una.vdc.model.user.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ulrik
 */
public class StudentDAO extends GenericDAO<Long, Student> {

    private final ProjectDAO pdao;

    public StudentDAO(EntityManager entityManager) {
        super(entityManager);
        pdao = new ProjectDAO(entityManager);
    }

    public void insertStudentsToGroup(List<Student> s, TIDIRProject p) throws UpdateException {
        try {
            et.begin();
            for (Student student : s) {
                student.setTidirGroup(pdao.getById(p.getId()));
                em.merge(student);
            }
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new UpdateException(e.getMessage());
        }
    }

    public List<Student> getStudentsByProject(long idProject) {
        Query q = em.createQuery("SELECT s FROM Student s JOIN s.tidirProject t WHERE t.id = :tid ");
        q.setParameter("tid", idProject);
        return q.getResultList();
    }

    public boolean checkIfStudentIsInProject(Student s, TIDIRProject p) {
        List<Student> students = getStudentsByProject(p.getId());
        return students.contains(s);
    }

}
