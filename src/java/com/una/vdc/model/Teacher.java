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
import javax.persistence.Id;

/**
 *
 * @author Ulrik
 */
@Entity
public class Teacher implements Serializable {

    @Id
    @GeneratedValue
    private Long ID;
    private String name;

//    @ManyToMany(mappedBy = "teachers", cascade = CascadeType.ALL)
//    private List<CollegeClass> classes;
//
//    public List<CollegeClass> getClasses() {
//        return classes;
//    }
//
//    public void setClasses(List<CollegeClass> classes) {
//        this.classes = classes;
//    }
//    


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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ID != null ? ID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.ID == null && other.ID != null) || (this.ID != null && !this.ID.equals(other.ID))) {
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
