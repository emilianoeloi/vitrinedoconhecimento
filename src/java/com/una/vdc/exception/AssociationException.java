/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.exception;

/**
 *
 * @author Ulrik
 */
public class AssociationException extends Exception {

    public AssociationException(String message) {
        super("AssociateException: "+message);
    }
    
}
