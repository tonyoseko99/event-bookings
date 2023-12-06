package com.tonnyseko.servlet.app.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        
        String jpql = "FROM " + entity.getSimpleName() + " e";
        System.out.println(jpql);
        return (List<T>) database.createQuery(jpql, entity).getResultList();
    }

    @Override
    public void addOrUpdate(T entity) {
        database.merge(entity);
    }

    @Override
    public void delete(T entity) {
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
