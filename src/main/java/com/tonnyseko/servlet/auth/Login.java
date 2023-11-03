package com.tonnyseko.servlet.auth;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(StringUtils.isNotBlank((String) session.getAttribute("loggedInId")))
            resp.sendRedirect("./home");
        else
            resp.sendRedirect("./");
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        HttpSession session = req.getSession();
        session.setAttribute("loggedInId", new Date().getTime() + "");

        ServletContext context = getServletContext();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals(context.getInitParameter("username")) && password.equals(context.getInitParameter("password"))){
            session.setAttribute("username", username);
            resp.sendRedirect("./home");
        } else {
            PrintWriter print = resp.getWriter();
            print.write("<html><body>Invalid login details <a href=\".\"> Login again </a></body></html>");
        }

    }
}
