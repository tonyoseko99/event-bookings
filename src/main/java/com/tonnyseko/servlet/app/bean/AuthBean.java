package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.entity.User;
import com.tonnyseko.servlet.database.MySqlDB;

import java.io.Serializable;
import java.util.List;

public class AuthBean implements AuthBeanI, Serializable {


    @Override
    public User authenticate(User loginUser) {
        try {
            MySqlDB database = MySqlDB.getInstance();
            List<User> users = MySqlDB.select(User.class);
            for (User user : users) {
                if (user.getUsername().equals(loginUser.getUsername()) && user.getPassword().equals(loginUser.getPassword())) {
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
