/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model;

import com.una.vdc.exception.InsertException;
import java.io.Serializable;
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
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String name;



    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    
    
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getNome() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param nome new value of name
     */
    public void setNome(String nome) {
        this.name = nome;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }


    

    public void validade() throws InsertException {
        if (name == null) {
            throw new InsertException("Teacher name cannot be null");
        }
    }

}
