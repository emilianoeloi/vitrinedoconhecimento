/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.persistence.dao;

import com.una.vdc.exception.InsertException;
import com.una.vdc.exception.UpdateException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Ulrik
 */
public class GenericDAO<PK, T> {

    protected EntityManager em;
    protected EntityTransaction et;

    public GenericDAO(EntityManager entityManager) {
        this.em = entityManager;
        this.et = em.getTransaction();
    }

    public T getById(PK pk) {
        return (T) em.find(getTypeClass(), pk);
    }

    public void save(T entity) throws InsertException {
        try {
            et.begin();
            em.persist(entity);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new InsertException(e.getMessage());
        }
    }

    public void update(T entity) throws UpdateException{
        try {
            et.begin();
            em.merge(entity);
            em.flush();
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new UpdateException(e.getMessage());
        }
        
    }

    public void delete(T entity) throws UpdateException {
        try {
            et.begin();
            em.remove(entity);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new UpdateException(e.getMessage());
        }
        
    }

    public List<T> findAll() {
        return em.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}
