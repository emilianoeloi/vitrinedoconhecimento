/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model;

import com.una.vdc.exception.InsertException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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

    @ManyToMany
    private List<CollegeClass> classes;

    public Course() {
    }

    public Course(String name, List<CollegeClass> turmas) {
        this.name = name;
        this.classes = turmas;
    }
    
    /**
     * Get the value of turma
     *
     * @return the value of turma
     */
    public List<CollegeClass> getTurma() {
        return classes;
    }

    /**
     * Set the value of turma
     *
     * @param turma new value of turma
     */
    public void setTurma(List<CollegeClass> turma) {
        this.classes = turma;
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

    public void validade() throws InsertException {
        if (name == null) {
            throw new InsertException("Course name cannot be null");
        }
    }

}
