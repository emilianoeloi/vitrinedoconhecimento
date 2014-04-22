/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.user;

import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.project.TIDIRProject;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ulrik
 */
@Entity
public class Student extends User {

    @ManyToOne(cascade = CascadeType.ALL)
    private CollegeClass collegeClass;

    @ManyToOne(cascade = CascadeType.ALL)
    private TIDIRProject tidirProject;

    private String ra;

    public Student() {
    }

    /**
     * Get the value of ra
     *
     * @return the value of ra
     */
    public String getRa() {
        return ra;
    }

    /**
     * Set the value of ra
     *
     * @param ra new value of ra
     */
    public void setRa(String ra) {
        this.ra = ra;
    }

    /**
     * Get the value of tidirProject
     *
     * @return the value of tidirProject
     */
    public TIDIRProject getTidirProject() {
        return tidirProject;
    }

    /**
     * Set the value of tidirProject
     *
     * @param tidirProject new value of tidirProject
     */
    public void setTidirGroup(TIDIRProject tidirProject) {
        this.tidirProject = tidirProject;
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

}
