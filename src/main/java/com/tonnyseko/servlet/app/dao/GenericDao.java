package com.tonnyseko.servlet.app.dao;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import com.tonnyseko.servlet.app.model.entity.Reservation;

import java.util.List;

@Dependent
public class GenericDao<T> implements GenericDaoI<T> {
    @PersistenceContext
    private EntityManager database;

    @SuppressWarnings("unchecked")
    @Override
    public List<T> list(Class<?> entity) {
        if (database == null) {
            throw new NullPointerException("EntityManager is null");
        }
        String jpql = "SELECT e FROM " + entity.getSimpleName() + " e";
        List<T> entities = database.createQuery(jpql).getResultList();
        if (entities.isEmpty()) {
            System.out.println("No " + entity.getSimpleName() + "s " + "found");
        }
        return entities;

    }

    @Override
    public T addOrUpdate(T entity) {

        if (database == null) {
            throw new NullPointerException("EntityManager is null");
        }
        database.merge(entity);
        return entity;

    }

    @Override
    public List<Object[]> nativeQuery(String sql) {
        return database.createNativeQuery(sql).getResultList();
    }

    @Override
    public void delete(Class<?> klass, Long id) {
        Object entity = database.find(klass, id);
        if (entity == null) {
            throw new NullPointerException("Entity not found");
        }

        database.remove(entity);
    }

    @Override
    public EntityManager getDatabase() {
        return database;
    }

    @Override
    public void setDatabase(EntityManager database) {
        this.database = database;
    }

}
