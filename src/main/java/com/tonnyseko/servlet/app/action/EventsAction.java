package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.bean.EventInterface;
import com.tonnyseko.servlet.app.model.entity.Event;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/events")
public class EventsAction extends BaseAction {
    @Inject
    private EventInterface eventBean;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Event event = serializeForm(Event.class, request.getParameterMap());
        eventBean.addOrUpdate(event);
        response.sendRedirect("./events");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        renderPage(request, response, 1, Event.class, eventBean.list(Event.class));
    }
}
