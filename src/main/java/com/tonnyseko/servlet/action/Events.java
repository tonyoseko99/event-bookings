package com.tonnyseko.servlet.action;

import com.tonnyseko.servlet.app.bean.EventBean;
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
public class Events extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (StringUtils.isNotBlank((String) session.getAttribute("loggedInId"))) {
            String name = request.getParameter("event_name");
            String image = request.getParameter("event_image");
            String date = request.getParameter("event_date");
            String venue = request.getParameter("event_location");
            String time = request.getParameter("event_time");
            String guests = request.getParameter("event_guests");
            String description = request.getParameter("event_description");

            EventBean eventBean = new EventBean();
            eventBean.addEvent(name, image, venue, date, time, guests, description);

            response.sendRedirect("./events");
        } else {
            response.sendRedirect("./");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (StringUtils.isNotBlank((String) session.getAttribute("loggedInId"))) {
            EventBean bookingBean = new EventBean();

            new AppPage().renderHtml(request, response, 1,
                    bookingBean.listOfBookings() + "<br>" +
                            "<form method='post' action='./events'>" +
                            "<label for='event_name'>Event Name:</label><br>" +
                            "<input type='text' id='event_name' name='event_name'><br>" +
                            "<label for='event_image'>Event Image:</label><br>" +
                            "<input type='text' id='event_image' name='event_image'><br>" +
                            "<label for='event_date'>Event Date:</label><br>" +
                            "<input type='date' id='event_date' name='event_date'><br>" +
                            "<label for='event_location'>Event Location:</label><br>" +
                            "<input type='text' id='event_location' name='event_location'><br>" +
                            "<label for='event_time'>Event Time:</label><br>" +
                            "<input type='time' id='event_time' name='event_time'><br>" +
                            "<label for='event_guests'>Event Guests:</label><br>" +
                            "<input type='number' id='event_guests' name='event_guests'><br>" +
                            "<label for='event_description'>Event Description:</label><br>" +
                            "<textarea id='event_description' name='event_description'></textarea><br><br>" +
                            "<input type='submit' value='Add Event'>" +
                            "</form>");
        } else {
            response.sendRedirect("./");
        }

    }
}
