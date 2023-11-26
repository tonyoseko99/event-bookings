package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.bean.UserBean;
import com.tonnyseko.servlet.app.bean.UserBeanI;
import com.tonnyseko.servlet.app.model.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class UserAction extends BaseAction {


    UserBeanI userBean = new UserBean();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("./register.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User registerUser = new User();
        registerUser = serializeForm(registerUser, req.getParameterMap());

        try {
            if (userBean.register(registerUser)) {
                req.setAttribute("registrationSuccess", "Registration successful! Proceed to login.");
                resp.sendRedirect("./login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("./register.jsp");
        dispatcher.forward(req, resp);
    }
}
