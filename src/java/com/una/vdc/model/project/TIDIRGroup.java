/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.project;

import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.user.Student;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Ulrik
 */
@Entity
public class TIDIRGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "tidirGroup")
    private List<Student> students;

    @ManyToOne(cascade = CascadeType.ALL)
    private CollegeClass collegeClass;

    public TIDIRGroup() {
    }

    public TIDIRGroup(List<Student> students, CollegeClass collegeClass) {
        this.students = students;
        this.collegeClass = collegeClass;
    }
    
    /**
     * Get the value of collegeClass
     *
     * @return the value of collegeClass
     */
    public CollegeClass getCollegeClass() {
        return collegeClass;
    }

    /**
     * Set the value of collegeClass
     *
     * @param collegeClass new value of collegeClass
     */
    public void setCollegeClass(CollegeClass collegeClass) {
        this.collegeClass = collegeClass;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof TIDIRGroup)) {
            return false;
        }
        TIDIRGroup other = (TIDIRGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.una.vdc.model.TIDIRGroup[ id=" + id + " ]";
    }

}
