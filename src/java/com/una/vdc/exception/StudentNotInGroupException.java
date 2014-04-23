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
public class StudentNotInGroupException extends Exception {

    public StudentNotInGroupException() {
        super("Student must be in group to close a task ");
    }
}
