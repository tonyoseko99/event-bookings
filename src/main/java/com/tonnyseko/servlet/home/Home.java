package com.tonnyseko.servlet.home;

import com.tonnyseko.servlet.app.bean.BookingBean;
import com.tonnyseko.servlet.app.view.html.AppPage;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class Home extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if(StringUtils.isNotBlank((String) session.getAttribute("loggedInId"))){
            BookingBean bookingBean = new BookingBean();

            new AppPage().renderHtml(request, response, 0,
                    "<h2>List of Bookings</h2" + bookingBean.listOfBookings());
        } else {
            response.sendRedirect("./");
        }
        
    }
    
}
