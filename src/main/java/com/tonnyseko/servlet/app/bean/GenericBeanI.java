package com.tonnyseko.servlet.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI<T> extends Serializable {
    List<T> list();

    void addOrUpdate(Object object);

    void delete(T entity);

    List<T> list(Class<?> entity);
}
