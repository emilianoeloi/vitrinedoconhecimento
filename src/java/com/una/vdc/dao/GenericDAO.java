/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.vdc.dao;

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
    }

    public T getById(PK pk) {
        return (T) em.find(getTypeClass(), pk);
    }

    public void save(T entity) {
        et = em.getTransaction();
        et.begin();
        em.persist(entity);
        et.commit();
    }

    public void update(T entity) {
        et = em.getTransaction();
        et.begin();
        em.merge(entity);
        et.commit();
    }

    public void delete(T entity) {
        et = em.getTransaction();
        et.begin();
        em.remove(entity);
        et.commit();
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
