package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.entity.User;
import com.tonnyseko.servlet.app.utility.HashText;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AuthBean implements AuthBeanI, Serializable {
    @PersistenceContext
    private EntityManager database;
    @Inject
    private HashText hashText;

    @Override
    public User authenticate(User loginUser) {

        try {
            loginUser.setPassword(hashText.hash(loginUser.getPassword()));
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        List<User> users = database.createQuery("FROM User u WHERE u.password=:password AND u.username=:username", User.class)
                .setParameter("password", loginUser.getPassword())
                .setParameter("username", loginUser.getUsername())
                .getResultList();

        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            throw new RuntimeException("Invalid username or password");
        }

    }
}
