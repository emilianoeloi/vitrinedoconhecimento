/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.user;

import com.una.vdc.model.course.CollegeClass;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Ulrik
 */
@Entity
public class ModuleTeacher extends User {
    
    @ManyToMany(mappedBy = "moduleTeacher")
    private List<CollegeClass> collegeClass;
    
    /**
     * Get the value of collegeClass
     *
     * @return the value of collegeClass
     */
    public List<CollegeClass> getCollegeClass() {
        return collegeClass;
    }

    /**
     * Set the value of collegeClass
     *
     * @param collegeClass new value of collegeClass
     */
    public void setCollegeClass(List<CollegeClass> collegeClass) {
        this.collegeClass = collegeClass;
    }

    @Override
    public String toString() {
        return "[Module Teacher " + getName() + " ]"; //To change body of generated methods, choose Tools | Templates.
    }

}
