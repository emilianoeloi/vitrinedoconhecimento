/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.project;

import com.una.vdc.model.course.Course;
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
public class TIDIRStage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String stageName;

    @OneToMany(mappedBy = "tidirStage")
    private List<Activity> activities;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;

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

    /**
     * Get the value of activities
     *
     * @return the value of activities
     */
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * Set the value of activities
     *
     * @param activities new value of activities
     */
    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    /**
     * Get the value of stageName
     *
     * @return the value of stageName
     */
    public String getStageName() {
        return stageName;
    }

    /**
     * Set the value of stageName
     *
     * @param stageName new value of stageName
     */
    public void setStageName(String stageName) {
        this.stageName = stageName;
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
        if (!(object instanceof TIDIRStage)) {
            return false;
        }
        TIDIRStage other = (TIDIRStage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.una.vdc.model.student.TIDIRStage[ id=" + id + " ]";
    }

}
