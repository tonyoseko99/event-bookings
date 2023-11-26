package com.tonnyseko.servlet.app.model.entity;

import com.tonnyseko.servlet.app.action.BaseAction;
import com.tonnyseko.servlet.app.view.helper.HtmlForm;
import com.tonnyseko.servlet.app.view.helper.HtmlFormField;
import com.tonnyseko.servlet.database.helper.DbColumn;
import com.tonnyseko.servlet.database.helper.DbTable;

import java.io.Serializable;

@DbTable(tableName = "users")
@HtmlForm(label = "Add User", url = "/registration", httpMethod = "POST")
public class User extends BaseEntity {
    @DbColumn(columnName = "username")
    @HtmlFormField(label = "Username", name = "username")
    private String username;
    @DbColumn(columnName = "password")
    @HtmlFormField(label = "Password", name = "password")
    private String password;

    private String confirmPassword;
    public User() {}

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public User(Long id, String username, String password) {
        setId(id);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
