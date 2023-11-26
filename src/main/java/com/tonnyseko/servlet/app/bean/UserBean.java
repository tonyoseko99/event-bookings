package com.tonnyseko.servlet.app.bean;

import java.sql.SQLException;

import com.tonnyseko.servlet.app.model.entity.User;
import com.tonnyseko.servlet.database.MySqlDB;

public class UserBean extends GenericBean<User> implements UserBeanI {

    @Override
    public boolean register(User user) throws SQLException {
        String password = user.getPassword();
        String confirmPassword = user.getConfirmPassword();

        if (!password.equals(confirmPassword)) {
            throw new RuntimeException("Password and confirm password do not match");
        }

        MySqlDB.insert(user);
        return false;
    }

    @Override
    public boolean deleteUser(User user) {

        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

}
