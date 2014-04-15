/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.persistence.dao;

import com.una.vdc.exception.AssociationException;
import com.una.vdc.model.course.CollegeClass;
import com.una.vdc.model.user.User;
import java.util.List;

/**
 *
 * @author Ulrik
 */
public interface ITeacher {
    public List<User> getTeachersByName(String nome);
    public boolean checkIfTeacherIsInClass(User user, CollegeClass c);
    public void associateTeacherToClass(User user, CollegeClass c) throws AssociationException;
}
