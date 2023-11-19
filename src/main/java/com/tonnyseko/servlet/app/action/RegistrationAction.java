package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.model.User;
import com.tonnyseko.servlet.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationAction extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Database db = Database.getDbInstance();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("confirmPassword");

        if (password.equals(password2)) {
            db.getUsers().add(new User(100L, username, password));
            response.sendRedirect("./");
        } else {
            response.sendRedirect("./registration");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }
}
