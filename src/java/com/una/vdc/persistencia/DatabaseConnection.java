/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ulrik
 */
public class DatabaseConnection {

    private static DatabaseConnection databaseConnection;
    private EntityManager em;

    public static DatabaseConnection instance() {
        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("vdc_pu");
            databaseConnection.em = emf.createEntityManager();
        }
        return databaseConnection;
    }

    public EntityManager getManager() {
        return em;
    }
}
