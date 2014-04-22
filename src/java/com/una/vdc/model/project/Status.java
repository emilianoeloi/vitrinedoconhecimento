/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.model.project;

/**
 *
 * @author Ulrik
 */
public enum Status {

    INPROGRESS("Em andamento"), FINALIZED("Finalizada");

    private final String realName;

    private Status(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }
}
