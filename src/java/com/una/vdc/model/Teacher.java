/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model;

import com.una.vdc.exception.InsertException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
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
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "teachers", cascade = CascadeType.ALL)
    private List<CollegeClass> classes;

    public List<CollegeClass> getClasses() {
        return classes;
    }

    public void setClasses(List<CollegeClass> classes) {
        this.classes = classes;
    }
    


    public Teacher() {
    }
    
    public Teacher(Long id) {
        this.id = id;
    }

    public Teacher(String name) {
        this.name = name;
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
     * @param nome new value of name
     */
    public void setName(String nome) {
        this.name = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long ID) {
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
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


    
    

    public void validade() throws InsertException {
        if (name == null) {
            throw new InsertException("Teacher name cannot be null");
        }
    }

}
