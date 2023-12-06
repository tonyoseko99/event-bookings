package com.tonnyseko.servlet.app.dao;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface GenericDaoI<T> extends Serializable {
    List<T> list(Class<?> entity);

    void addOrUpdate(T entity);

    void delete(T entity);

    EntityManager getDatabase();

    void setDatabase(EntityManager database);
}
