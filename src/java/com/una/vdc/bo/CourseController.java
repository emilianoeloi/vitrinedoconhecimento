/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

import com.una.vdc.exception.DeleteException;
import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
import com.una.vdc.persistence.dao.CourseDAO;
import com.una.vdc.model.course.Course;
import com.una.vdc.persistence.DatabaseConnection;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class CourseController {

    private final CourseDAO dao;

    public CourseController() {
        EntityManager em = DatabaseConnection.instance().getManager();
        dao = new CourseDAO(em);
    }

    public Course getCourseById(Long id) {
        return dao.getById(id);
    }

    public List<Course> getAllCourses() {
        return dao.findAll();
    }

    public void insertCourse(Course c) throws InsertException {
        dao.save(c);
    }

    public void removeCourse(Course c) throws DeleteException {
        dao.delete(c);
    }

    public void updateCourse(Course c) throws UpdateException {
        dao.update(c);
    }
}
