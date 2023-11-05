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
import com.tonnyseko.servlet.app.view.html.AppPage;

@WebServlet("/add-event")
public class AddEvent extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (StringUtils.isNotBlank((String) session.getAttribute("loggedInId"))) {
            EventBean bookingBean = new EventBean();

            new AppPage().renderHtml(request, response, 0, "<form method='post' action='./events'>" +
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
                    "<label for='event_category'>Event Category:</label><br>" +
                    "<select id='event_category' name='event_category'>" +
                    "<option value='TECH'>Tech</option>" +
                    "<option value='BUSINESS'>Business</option>" +
                    "<option value='SPORTS'>Sports</option>" +
                    "<option value='ENTERTAINMENT'>Entertainment</option>" +
                    "<option value='OTHER'>Other</option>" +
                    "</select><br>" +
                    "<label for='event_description'>Event Description:</label><br>" +
                    "<textarea id='event_description' name='event_description'></textarea><br><br>" +
                    "<input type='submit' value='Add Event'>" +
                    "</form>" +
                    "<br><br>" +
                    "<button class='btn btn-primary' id='back'> <a href='./events'>Back</a></button>");
                    
        } else {
            response.sendRedirect("./");
        }

    }
}
