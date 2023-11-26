package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.entity.User;

import java.sql.SQLException;

public interface AuthBeanI {
    User authenticate(User loginUser) throws SQLException;
}
