/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.user;

import com.una.vdc.model.project.TIDIRGroup;
import com.una.vdc.model.user.User;
import com.una.vdc.model.course.CollegeClass;
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
    private TIDIRGroup tidirGroup;

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

}
