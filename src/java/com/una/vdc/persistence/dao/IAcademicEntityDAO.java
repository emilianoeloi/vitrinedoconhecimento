/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.persistence.dao;

import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.user.User;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IAcademicEntityDAO{
    
    public List<User> getTeacherByClass(CollegeClass c);
    public void associateTeacherToClass(User teacher, CollegeClass cclass);
            
}
