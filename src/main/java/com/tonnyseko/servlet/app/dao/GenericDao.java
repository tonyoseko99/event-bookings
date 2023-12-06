package com.tonnyseko.servlet.app.dao;

import com.tonnyseko.servlet.app.model.entity.Event;

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
//        List<T> entities = database.createQuery(jpql, entity).getResultList();
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
        database.persist(entity);
        return entity;
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
