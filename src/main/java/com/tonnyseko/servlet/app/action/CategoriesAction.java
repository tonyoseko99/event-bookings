package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.bean.EventBean;
import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.model.view.CategoryStatus;
import com.tonnyseko.servlet.app.view.helper.AppPage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/categories")
public class CategoriesAction extends BaseAction {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        EventBean eventBean = new EventBean();

        renderPage(request, response, 2, Event.class, eventBean.getEventsByCategory(CategoryStatus.valueOf(request.getParameter("category").toUpperCase())));

    }
}
