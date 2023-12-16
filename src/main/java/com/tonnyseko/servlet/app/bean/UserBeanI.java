package com.tonnyseko.servlet.app.bean;

import java.sql.SQLException;

import com.tonnyseko.servlet.app.model.entity.User;
import com.tonnyseko.servlet.app.model.enums.Role;

public interface UserBeanI {
    boolean register(User user) throws SQLException;

    boolean deleteUser(User user);
}
