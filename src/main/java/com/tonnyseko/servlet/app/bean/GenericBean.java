package com.tonnyseko.servlet.app.bean;

import java.util.List;

import com.tonnyseko.servlet.database.Database;

public class GenericBean<T> implements GenericBeanI<T> {

    @Override
    public List<T> list(Class<?> entity){
        
        return list();
    }

    @Override
    public List<T> list() {
        return list();
    }

    @Override
    public void addOrUpdate(Object object){

    }

    @Override
    public void delete(T entity){}
}