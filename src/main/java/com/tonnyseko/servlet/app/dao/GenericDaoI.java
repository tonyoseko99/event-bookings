package com.tonnyseko.servlet.app.dao;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface GenericDaoI<T> extends Serializable {
    List<T> list(Class<?> entity);

    T findById(Class<?> klass, Long id);

    List<Object[]> nativeQuery(String sql);

    T addOrUpdate(T entity);

    void delete(Class<?> klass, Long id);

    EntityManager getDatabase();

    void setDatabase(EntityManager database);
}
