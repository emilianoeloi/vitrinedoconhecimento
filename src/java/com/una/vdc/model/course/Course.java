<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.course;

import com.una.vdc.exception.InsertException;
import com.una.vdc.model.project.TIDIRStage;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Ulrik
 */
@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String name;
    
    @OneToMany(mappedBy = "course")
    private List<Period> period;
    
    /**
     * Get the value of period
     *
     * @return the value of period
     */
    public List<Period> getPeriod() {
        return period;
    }

    /**
     * Set the value of period
     *
     * @param period new value of period
     */
    public void setPeriod(List<Period> period) {
        this.period = period;
    }

    public Course() {
    }

    public Course(String name, CollegeClass clazz) {
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.ID == null && other.ID != null) || (this.ID != null && !this.ID.equals(other.ID))) {
            return false;
        }
        return true;
    }

    public void validade() throws InsertException {
        if (name == null) {
            throw new InsertException("Course name cannot be null");
        }
    }

}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.course;

import com.una.vdc.exception.InsertException;
import com.una.vdc.model.project.TIDIRStage;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Ulrik
 */
@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String name;
    
    @OneToMany(mappedBy = "course")
    private List<Period> period;
    
    /**
     * Get the value of period
     *
     * @return the value of period
     */
    public List<Period> getPeriod() {
        return period;
    }

    /**
     * Set the value of period
     *
     * @param period new value of period
     */
    public void setPeriod(List<Period> period) {
        this.period = period;
    }

    public Course() {
    }

    public Course(String name, CollegeClass clazz) {
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.ID == null && other.ID != null) || (this.ID != null && !this.ID.equals(other.ID))) {
            return false;
        }
        return true;
    }

    public void validade() throws InsertException {
        if (name == null) {
            throw new InsertException("Course name cannot be null");
        }
    }

}
>>>>>>> 613f669a22e9b2b6f8de3f0a0dce662163a3a277
