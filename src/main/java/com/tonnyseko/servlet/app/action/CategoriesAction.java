package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.bean.EventBean;
import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.model.enums.CategoryStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/categories")
public class CategoriesAction extends BaseAction {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventBean eventBean = new EventBean();

        renderPage(request, response, 2, Event.class, eventBean.getEventsByCategory(CategoryStatus.valueOf(request.getParameter("category").toUpperCase())));

    }
}
