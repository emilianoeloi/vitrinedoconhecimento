/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.course;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Ulrik
 */
@Entity
public class Period implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String periodDescription;
    @ManyToOne
    private Course course;
    @OneToOne(cascade = CascadeType.ALL)
    private Module module;

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
     * Get the value of periodDescription
     *
     * @return the value of periodDescription
     */
    public String getPeriodDescription() {
        return periodDescription;
    }

    /**
     * Set the value of periodDescription
     *
     * @param periodDescription new value of periodDescription
     */
    public void setPeriodDescription(String periodDescription) {
        this.periodDescription = periodDescription;
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
        if (!(object instanceof Period)) {
            return false;
        }
        Period other = (Period) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.una.vdc.model.period.Period[ id=" + id + " ]";
    }

}
