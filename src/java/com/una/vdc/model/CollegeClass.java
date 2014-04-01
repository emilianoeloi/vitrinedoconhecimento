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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Ulrik
 */
@Entity
public class CollegeClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name="classes_has_teachers", joinColumns={@JoinColumn(name="cclass_id")}, inverseJoinColumns={@JoinColumn(name="teacher_id")})
    private List<Teacher> teachers;

    public CollegeClass() {
    }

    public CollegeClass(String name) {
        this.name = name;
    }

    /**
     * Get the value of professor
     *
     * @return the value of professor
     */
    public List<Teacher> getProfessor() {
        return teachers;
    }

    /**
     * Set the value of professor
     *
     * @param professor new value of professor
     */
    public void setProfessor(List<Teacher> professor) {
        this.teachers = professor;
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
        this.id = id;
    }

    public void validade() throws InsertException {
        if (name == null) {
            throw new InsertException("Class name cannot be null");
        }
    }

}
