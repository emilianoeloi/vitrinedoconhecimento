/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.student;

import com.una.vdc.model.project.TIDIRGroup;
import com.una.vdc.exception.InsertException;
import com.una.vdc.model.course.CollegeClass;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ulrik
 */
@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private CollegeClass collegeClass;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private TIDIRGroup tidirGroup;

    /**
     * Get the value of tidirGroup
     *
     * @return the value of tidirGroup
     */
    public TIDIRGroup getTidirGroup() {
        return tidirGroup;
    }

    /**
     * Set the value of tidirGroup
     *
     * @param tidirGroup new value of tidirGroup
     */
    public void setTidirGroup(TIDIRGroup tidirGroup) {
        this.tidirGroup = tidirGroup;
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

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ID != null ? ID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.ID == null && other.ID != null) || (this.ID != null && !this.ID.equals(other.ID))) {
            return false;
        }
        return true;
    }

    public void validade() throws InsertException {
        if (name == null) {
            throw new InsertException("Student name cannot be null");
        }
    }
}
