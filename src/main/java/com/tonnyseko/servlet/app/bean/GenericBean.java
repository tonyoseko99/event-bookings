package com.tonnyseko.servlet.app.bean;

import java.util.List;

import com.tonnyseko.servlet.app.dao.GenericDao;
import com.tonnyseko.servlet.app.dao.GenericDaoI;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericBean<T> implements GenericBeanI<T> {

    @PersistenceContext
    private EntityManager database;

    @Inject
    private GenericDaoI<T> genericDao;

    @Override
    public List<T> list(Class<?> entity) {
        if (database == null) {
            throw new IllegalStateException("EntityManager is null. Make sure it is properly injected.");
        }
        genericDao.setDatabase(database);
        return genericDao.list(entity);
    }

    @Override
    public T findById(Class<?> klass, Long id) {
        if (database == null) {
            throw new IllegalStateException("EntityManager is null. Make sure it is properly injected.");
        }
        genericDao.setDatabase(database);
        return genericDao.findById(klass, id);
    }

    @Override
    public void addOrUpdate(T entity) {
        if (database == null) {
            throw new IllegalStateException("EntityManager is null. Make sure it is properly injected.");
        }
        genericDao.setDatabase(database);
        genericDao.addOrUpdate(entity);
    }

    @Override
    public void delete(Class<?> klass, Long id) {
        if (database == null) {
            throw new IllegalStateException("EntityManager is null. Make sure it is properly injected.");
        }
        genericDao.setDatabase(database);
        genericDao.delete(klass, id);

    }

    public GenericDao<T> getDao() {
        if (database == null) {
            throw new IllegalStateException("EntityManager is null. Make sure it is properly injected.");
        }
        genericDao.setDatabase(database);
        return (GenericDao<T>) genericDao;
    }
}