/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.project;

import com.una.vdc.model.user.Student;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Ulrik
 */
@Entity
public class TaskSituation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Task task;

    @OneToOne
    private Student student;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar endDate;

    private Status status;
    
    @OneToOne
    private TIDIRProject project;

    public TaskSituation() {
        this.status = Status.INPROGRESS;
    }

    /**
     * Get the value of project
     *
     * @return the value of project
     */
    public TIDIRProject getProject() {
        return project;
    }

    /**
     * Set the value of project
     *
     * @param project new value of project
     */
    public void setProject(TIDIRProject project) {
        this.project = project;
    }

    /**
     * Get the value of status
     *
     * @return the value of status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Set the value of status
     *
     * @param status new value of status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Get the value of endDate
     *
     * @return the value of endDate
     */
    public Calendar getEndDate() {
        return endDate;
    }

    /**
     * Set the value of endDate
     *
     * @param endDate new value of endDate
     */
    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    /**
     * Get the value of student
     *
     * @return the value of student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Set the value of student
     *
     * @param student new value of student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Get the value of task
     *
     * @return the value of task
     */
    public Task getTask() {
        return task;
    }

    /**
     * Set the value of task
     *
     * @param task new value of task
     */
    public void setTask(Task task) {
        this.task = task;
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
        if (!(object instanceof TaskSituation)) {
            return false;
        }
        TaskSituation other = (TaskSituation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.una.vdc.model.project.TaskSituation[ id=" + id + " ]";
    }

}
