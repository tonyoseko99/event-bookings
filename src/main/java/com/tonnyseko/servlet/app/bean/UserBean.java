package com.tonnyseko.servlet.app.bean;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.tonnyseko.servlet.app.model.entity.User;
import com.tonnyseko.servlet.app.utility.HashText;


@Stateless
public class UserBean extends GenericBean<User> implements UserBeanI {

    @Inject
    private HashText hashText;

    @Override
    public boolean register(User user) throws SQLException {

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new RuntimeException("Password and confirm password do not match");
        }

        // check if user exists
        List<User> existingUsers = list(User.class);
        for (User u : existingUsers) {
            if (u.getUsername().equals(user.getUsername())) {
                throw new RuntimeException("User with email " + user.getUsername() + " already exists");
            }
        }

        try {
            user.setPassword(hashText.hash(user.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password");
        }

        getDao().addOrUpdate(user);
        return false;
    }

    @Override
    public boolean deleteUser(User user) {

        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

}
