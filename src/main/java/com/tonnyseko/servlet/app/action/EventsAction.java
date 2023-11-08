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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/events")
public class EventsAction extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String name = request.getParameter("event_name");
        String image = request.getParameter("event_image");
        String date = request.getParameter("event_date");
        String venue = request.getParameter("event_location");
        String time = request.getParameter("event_time");
        CategoryStatus category = CategoryStatus.valueOf(request.getParameter("event_category"));
        String description = request.getParameter("event_description");

        EventBean eventBean = new EventBean();
        eventBean.addEvent(name, image, venue, date, time, category, description);

        response.sendRedirect("./events");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        EventBean bookingBean = new EventBean();

        new AppPage().renderHtml(request, response, 1,

                "<button class=\"btn btn-primary\" id=\"add-event\"> <a href=\"./add-event\">Add Event</a></button>" +
                        "<br><br>"

                        +

                        bookingBean.listOfBookings());


    }
}
