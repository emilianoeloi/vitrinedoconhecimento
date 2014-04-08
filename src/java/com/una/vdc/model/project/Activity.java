/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.project;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Ulrik
 */
@Entity
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descAtivity;

    @ManyToOne(cascade = CascadeType.ALL)
    private TIDIRStage tidirStage;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date expectedStart;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date expectedEnd;

    /**
     * Get the value of expectedEnd
     *
     * @return the value of expectedEnd
     */
    public Date getExpectedEnd() {
        return expectedEnd;
    }

    /**
     * Set the value of expectedEnd
     *
     * @param expectedEnd new value of expectedEnd
     */
    public void setExpectedEnd(Date expectedEnd) {
        this.expectedEnd = expectedEnd;
    }

    /**
     * Get the value of expectedStart
     *
     * @return the value of expectedStart
     */
    public Date getExpectedStart() {
        return expectedStart;
    }

    /**
     * Set the value of expectedStart
     *
     * @param expectedStart new value of expectedStart
     */
    public void setExpectedStart(Date expectedStart) {
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
     * Get the value of descAtivity
     *
     * @return the value of descAtivity
     */
    public String getDescAtivity() {
        return descAtivity;
    }

    /**
     * Set the value of descAtivity
     *
     * @param descAtivity new value of descAtivity
     */
    public void setDescAtivity(String descAtivity) {
        this.descAtivity = descAtivity;
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
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
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
