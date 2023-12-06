package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.bean.AuthBean;
import com.tonnyseko.servlet.app.bean.AuthBeanI;
import com.tonnyseko.servlet.app.model.entity.User;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/login")
public class LoginAction extends BaseAction {

    @Inject
    private AuthBeanI authBean;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (StringUtils.isNotBlank((String) session.getAttribute("loggedInId")))
            resp.sendRedirect("./events");
        else
            resp.sendRedirect("./");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User loginUser = serializeForm(User.class, req.getParameterMap());

        try {
            User userDetails = authBean.authenticate(loginUser);

            if (userDetails != null) {
                HttpSession session = req.getSession(true);
                session.setAttribute("loggedInId", String.valueOf(new Date().getTime()));
                session.setAttribute("username", userDetails.getUsername());

                resp.sendRedirect("./events");

            } else {
                req.setAttribute("loginError", "Invalid login details");
                req.getRequestDispatcher("./index.jsp").forward(req, resp);

            }
        } catch (Exception e) {
            req.setAttribute("loginError", "Invalid login details");
            req.getRequestDispatcher("./index.jsp").forward(req, resp);
        }
    }
}
