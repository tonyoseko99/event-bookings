package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.bean.EventBean;
import com.tonnyseko.servlet.app.model.entity.Event;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeAction extends BaseAction {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EventBean bookingBean = new EventBean();

        renderPage(request, response, 1, Event.class, bookingBean.getFeaturedEvent());

    }

}
