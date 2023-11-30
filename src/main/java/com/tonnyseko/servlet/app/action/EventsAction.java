package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.bean.EventBean;
import com.tonnyseko.servlet.app.model.entity.Event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/events")
public class EventsAction extends BaseAction {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EventBean eventBean = new EventBean();
        Class<Event> event = serializeForm(Event.class, request.getParameterMap());
        eventBean.addOrUpdate(event);
        response.sendRedirect("./events");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventBean bookingBean = new EventBean();
        renderPage(request, response, 1, Event.class, bookingBean.list());

    }
}
