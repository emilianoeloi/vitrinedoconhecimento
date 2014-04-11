/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.course;

import com.una.vdc.exception.InsertException;
import com.una.vdc.model.project.TIDIRGroup;
import com.una.vdc.model.user.Student;
import com.una.vdc.model.user.MentorTeacher;
import com.una.vdc.model.user.ModuleTeacher;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Ulrik
 */
@Entity
public class CollegeClass implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "collegeClass")
    private List<Student> students;

    @ManyToOne(cascade = CascadeType.ALL)
    private MentorTeacher mentorTeacher;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<ModuleTeacher> moduleTeacher;

    @ManyToOne(cascade = CascadeType.ALL)
    private Period period;

    public CollegeClass() {
    }

    /**
     * Get the value of period
     *
     * @return the value of period
     */
    public Period getPeriod() {
        return period;
    }

    /**
     * Set the value of period
     *
     * @param period new value of period
     */
    public void setPeriod(Period period) {
        this.period = period;
    }

    /**
     * Get the value of moduleTeacher
     *
     * @return the value of moduleTeacher
     */
    public List<ModuleTeacher> getModuleTeacher() {
        return moduleTeacher;
    }

    /**
     * Set the value of moduleTeacher
     *
     * @param moduleTeacher new value of moduleTeacher
     */
    public void setModuleTeacher(List<ModuleTeacher> moduleTeacher) {
        this.moduleTeacher = moduleTeacher;
    }

    /**
     * Get the value of mentorTeacher
     *
     * @return the value of mentorTeacher
     */
    public MentorTeacher getMentorTeacher() {
        return mentorTeacher;
    }

    /**
     * Set the value of mentorTeacher
     *
     * @param mentorTeacher new value of mentorTeacher
     */
    public void setMentorTeacher(MentorTeacher mentorTeacher) {
        this.mentorTeacher = mentorTeacher;
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

    public CollegeClass(String name) {
        this.name = name;
    }

    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return name;
    }

    /**
     * Set the value of nome
     *
     * @param nome new value of nome
     */
    public void setNome(String nome) {
        this.name = nome;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long ID) {
        this.id = ID;
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
        if (!(object instanceof CollegeClass)) {
            return false;
        }
        CollegeClass other = (CollegeClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public void validade() throws InsertException {
        if (name == null) {
            throw new InsertException("Class name cannot be null");
        }
    }

}
