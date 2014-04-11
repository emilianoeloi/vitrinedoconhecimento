/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.exception;

/**
 *
 * @author daniel
 */
public class UpdateException extends Exception{

    public UpdateException(String message) {
        super("UpdateException: "+message);
    }
    
}
