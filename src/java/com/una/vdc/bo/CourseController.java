/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.bo;

import com.una.vdc.dao.CourseDAO;
import com.una.vdc.model.Course;
import com.una.vdc.persistencia.DatabaseConnection;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ulrik
 */
public class CourseController {

    private CourseDAO dao;

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

    public void insertCourse(Course c) {
        dao.save(c);
    }

    public void removeCourse(Course c) {
        dao.delete(c);
    }

    public void updateCourse(Course c) {
        dao.update(c);
    }
}
