/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.project;

import com.una.vdc.model.user.User;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Ulrik
 */
@Entity
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descTask;

    @ManyToOne(cascade = CascadeType.ALL)
    private TIDIRStage tidirStage;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar expectedStart;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar expectedEnd;

    @OneToOne
    private User createdBy;

    public Task() {
    }

    /**
     * Get the value of createdBy
     *
     * @return the value of createdBy
     */
    public User getCreatedBy() {
        return createdBy;
    }

    /**
     * Set the value of createdBy
     *
     * @param createdBy new value of createdBy
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Get the value of expectedEnd
     *
     * @return the value of expectedEnd
     */
    public Calendar getExpectedEnd() {
        return expectedEnd;
    }

    /**
     * Set the value of expectedEnd
     *
     * @param expectedEnd new value of expectedEnd
     */
    public void setExpectedEnd(Calendar expectedEnd) {
        this.expectedEnd = expectedEnd;
    }

    /**
     * Get the value of expectedStart
     *
     * @return the value of expectedStart
     */
    public Calendar getExpectedStart() {
        return expectedStart;
    }

    /**
     * Set the value of expectedStart
     *
     * @param expectedStart new value of expectedStart
     */
    public void setExpectedStart(Calendar expectedStart) {
        this.expectedStart = expectedStart;
    }

    /**
     * Get the value of tidirStage
     *
     * @return the value of tidirStage
     */
    public TIDIRStage getTidirStage() {
        return tidirStage;
    }

    /**
     * Set the value of tidirStage
     *
     * @param tidirStage new value of tidirStage
     */
    public void setTidirStage(TIDIRStage tidirStage) {
        this.tidirStage = tidirStage;
    }

    /**
     * Get the value of descTask
     *
     * @return the value of descTask
     */
    public String getDescTask() {
        return descTask;
    }

    /**
     * Set the value of descTask
     *
     * @param descTask new value of descTask
     */
    public void setDescTask(String descTask) {
        this.descTask = descTask;
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
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.una.vdc.model.project.Activity[ id=" + id + " ]";
    }

}
