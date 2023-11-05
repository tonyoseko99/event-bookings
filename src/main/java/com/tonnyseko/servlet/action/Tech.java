package com.tonnyseko.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.tonnyseko.servlet.app.bean.EventBean;
import com.tonnyseko.servlet.app.view.html.AppPage;

@WebServlet("/categories?category=tech")
public class Tech extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (StringUtils.isNotBlank((String) session.getAttribute("loggedInId"))) {
            EventBean bookingBean = new EventBean();

            new AppPage().renderHtml(request, response, 0,
                    bookingBean.sortPerCategory());
        } else {
            response.sendRedirect("./");
        }

    }
}
