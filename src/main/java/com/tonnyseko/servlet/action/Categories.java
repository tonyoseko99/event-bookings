package com.tonnyseko.servlet.action;

import com.tonnyseko.servlet.app.bean.EventBean;
import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.model.view.CategoryStatus;
import com.tonnyseko.servlet.app.view.html.AppPage;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/categories")
public class Categories extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        EventBean eventBean = new EventBean();

        if (StringUtils.isNotBlank((String) session.getAttribute("loggedInId"))) {
            new AppPage().renderHtml(request, response, 2, eventBean.getCategories());
        } else {
            response.sendRedirect("./");
        }
    }
}
