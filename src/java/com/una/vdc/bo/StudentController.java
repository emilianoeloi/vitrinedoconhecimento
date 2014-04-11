<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

import com.una.vdc.persistence.dao.StudentDAO;
import com.una.vdc.model.user.Student;
import com.una.vdc.persistence.DatabaseConnection;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class StudentController {

    private StudentDAO dao;

    public StudentController() {
        EntityManager em = DatabaseConnection.instance().getManager();
        dao = new StudentDAO(em);
    }

    public Student getStudentById(Long id) {
        return dao.getById(id);
    }

    public List<Student> getAllStudents() {
        return dao.findAll();
    }

    public void insertStudent(Student s) {
        dao.save(s);
    }

    public void removeStudent(Student s) {
        dao.delete(s);
    }

    public void updateStudent(Student s) {
        dao.update(s);
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
import com.una.vdc.persistence.dao.StudentDAO;
import com.una.vdc.model.user.Student;
import com.una.vdc.persistence.DatabaseConnection;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class StudentController {

    private final StudentDAO dao;

    public StudentController() {
        EntityManager em = DatabaseConnection.instance().getManager();
        dao = new StudentDAO(em);
    }

    public Student getStudentById(Long id) {
        return dao.getById(id);
    }

    public List<Student> getAllStudents() {
        return dao.findAll();
    }

    public void insertStudent(Student s) throws InsertException {
        dao.save(s);
    }

    public void removeStudent(Student s) throws UpdateException {
        dao.delete(s);
    }

    public void updateStudent(Student s) throws UpdateException {
        dao.update(s);
    }
}
>>>>>>> 613f669a22e9b2b6f8de3f0a0dce662163a3a277
