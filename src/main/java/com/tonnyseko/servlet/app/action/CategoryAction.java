package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.bean.EventBean;
import com.tonnyseko.servlet.app.model.view.CategoryStatus;
import com.tonnyseko.servlet.app.view.html.AppPage;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/categories")
public class CategoryAction extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryParam = request.getParameter("category");
        if (StringUtils.isBlank(categoryParam)) {
            response.sendRedirect("home");
            return;
        }

        CategoryStatus category = CategoryStatus.valueOf(categoryParam.toUpperCase());

        EventBean bookingBean = new EventBean();

        String categoryHtml = bookingBean.sortPerCategory(category);

        new AppPage().renderHtml(request, response, 0,
                categoryHtml);

    }
}
