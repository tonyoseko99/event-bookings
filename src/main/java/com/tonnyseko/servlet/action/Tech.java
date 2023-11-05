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
import com.tonnyseko.servlet.app.model.view.CategoryStatus;
import com.tonnyseko.servlet.app.view.html.AppPage;

@WebServlet("/TECH")
public class Tech extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (StringUtils.isNotBlank((String) session.getAttribute("loggedInId"))) {
            EventBean eventBean = new EventBean();
            String categoryParam = request.getParameter("category");
            
            if (categoryParam != null) {
                CategoryStatus category = CategoryStatus.valueOf(categoryParam.toUpperCase());
                new AppPage().renderHtml(request, response, 0, eventBean.sortPerCategory(category));
            } else {
                // Handle the case when no category is selected
                response.sendRedirect("./categories");
            }
        } else {
            response.sendRedirect("./");
        }
    }
}
