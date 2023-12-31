package com.tonnyseko.servlet.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI<T> extends Serializable {
    List<T> list(Class<?> entity);

    T findById(Class<?> klass, Long id);

    void addOrUpdate(T entity);

    void delete(Class<?> klass, Long id);
}
