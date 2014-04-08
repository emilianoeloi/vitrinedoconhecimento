/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.course;

import com.una.vdc.model.teacher.Teacher;
import com.una.vdc.exception.InsertException;
import com.una.vdc.model.student.Student;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Ulrik
 */
@Entity
public class CollegeClass implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Teacher> teachers;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    private Module module;
    
    @OneToMany(mappedBy = "collegeClass")
    private List<Student> students;

    /**
     * Get the value of students
     *
     * @return the value of students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Set the value of students
     *
     * @param students new value of students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * Get the value of module
     *
     * @return the value of module
     */
    public Module getModule() {
        return module;
    }

    /**
     * Set the value of module
     *
     * @param module new value of module
     */
    public void setModule(Module module) {
        this.module = module;
    }

    /**
     * Get the value of course
     *
     * @return the value of course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Set the value of course
     *
     * @param course new value of course
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    public CollegeClass() {
    }

    public CollegeClass(String name) {
        this.name = name;
    }

    /**
     * Get the value of professor
     *
     * @return the value of professor
     */
    public List<Teacher> getTeacher() {
        return teachers;
    }

    /**
     * Set the value of professor
     *
     * @param professor new value of professor
     */
    public void setTeacher(List<Teacher> professor) {
        this.teachers = professor;
    }

    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return name;
    }

    /**
     * Set the value of nome
     *
     * @param nome new value of nome
     */
    public void setNome(String nome) {
        this.name = nome;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long ID) {
        this.id = ID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollegeClass)) {
            return false;
        }
        CollegeClass other = (CollegeClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public void validade() throws InsertException {
        if (name == null) {
            throw new InsertException("Class name cannot be null");
        }
    }

}
