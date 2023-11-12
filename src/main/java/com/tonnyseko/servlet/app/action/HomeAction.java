package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.bean.EventBean;
import com.tonnyseko.servlet.app.view.helper.AppPage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeAction extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        EventBean bookingBean = new EventBean();

        new AppPage().renderHtml(request, response, 0,
                bookingBean.getFeaturedEvent());


    }

}
