/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.exception;

/**
 *
 * @author emilianoeloi
 */
public class InsertException extends Exception {
    public InsertException(String message) {
        super("InsertException: "+message);
    }
}

