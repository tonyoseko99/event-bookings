package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.bean.AuthBean;
import com.tonnyseko.servlet.app.bean.AuthBeanI;
import com.tonnyseko.servlet.app.model.entity.User;
import com.tonnyseko.servlet.database.Database;
import com.tonnyseko.servlet.database.MySqlDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/login")
public class LoginAction extends BaseAction {
    private static final Logger LOGGER = Logger.getLogger(LoginAction.class.getName());
    AuthBeanI authBean = new AuthBean();
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("loggedInId") != null) {
            resp.sendRedirect(req.getContextPath() + "/events");
        } else {
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User loginUser = new User();
        serializeForm(loginUser, req.getParameterMap());

        try{
            User userDetails = authBean.authenticate(loginUser);

            if(userDetails != null){
                HttpSession session = req.getSession(true);
                session.setAttribute("loggedInId", String.valueOf(new Date().getTime()));
                session.setAttribute("username", userDetails.getUsername());

            } else {
                req.setAttribute("loginError", "Invalid login details");
                req.getRequestDispatcher("./index.jsp").forward(req, resp);

            }
        } catch(Exception e) {
            req.setAttribute("loginError", "Invalid login details");
            req.getRequestDispatcher("./index.jsp").forward(req, resp);
        }
    }
}
