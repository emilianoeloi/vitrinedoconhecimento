/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.user;

import javax.persistence.Entity;

/**
 *
 * @author Ulrik
 */
@Entity
public class Coordinator extends User{

    @Override
    public String toString() {
        return "[Coordinator "+getName()+" ]"; //To change body of generated methods, choose Tools | Templates.
    }   
    
}
