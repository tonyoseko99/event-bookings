package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.bean.ReservationI;
import com.tonnyseko.servlet.app.model.entity.Reservation;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reservations")
public class ReservationsAction extends BaseAction {
    @Inject
    private ReservationI reservationBean;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ReservationsAction.doPost");
        reservationBean.addReservation(serializeForm(Reservation.class, request.getParameterMap()));
        System.out.println(reservationBean.toString());
        response.sendRedirect(request.getContextPath() + "/reservations");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        renderPage(request, response, 3, Reservation.class, reservationBean.list(Reservation.class));
    }


}
