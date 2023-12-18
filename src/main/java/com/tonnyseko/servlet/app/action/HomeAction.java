package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.bean.EventInterface;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeAction extends BaseAction {
    @Inject
    private EventInterface bookingBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // renderPage(request, response, 1, Event.class, bookingBean.getFeaturedEvent());

    }

}
