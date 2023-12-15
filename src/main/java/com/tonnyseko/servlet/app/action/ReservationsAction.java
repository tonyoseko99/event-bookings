package com.tonnyseko.servlet.app.action;

import com.tonnyseko.servlet.app.bean.ReservationI;
import com.tonnyseko.servlet.app.model.entity.Address;
import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.model.entity.Reservation;
import com.tonnyseko.servlet.app.model.entity.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reservations")
public class ReservationsAction extends BaseAction {

    @PersistenceContext
    private EntityManager database;

    @Inject
    private ReservationI reservationBean;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Convert the form data into a Reservation object
        Reservation reservation = serializeForm(Reservation.class, request.getParameterMap());
    
        // Extract the event_id and user_id from the form data
        String eventId = request.getParameter("event_id");
        String userId = request.getParameter("user_id");
    
        // Fetch the Event and User objects with these IDs from the database
        Event event = database.find(Event.class, Long.valueOf(eventId));
        User user = database.find(User.class, Long.valueOf(userId));
    
        // Set the event and user fields of the Reservation object
        reservation.setEvent(event);
        reservation.setUser(user);
    
        // Create an Address object from the address.* fields in the form data
        Address address = new Address();
        address.setCity(request.getParameter("address.city"));
        address.setEmail(request.getParameter("address.email"));
        address.setPhone(request.getParameter("address.phone"));
        address.setZipCode(request.getParameter("address.zipCode"));
    
        // Set the address field of the Reservation object
        // reservation.setAddress(address);
    
        // Save the Reservation object to the database
        reservationBean.addOrUpdate(reservation);
    
        // Redirect to the reservations page
        response.sendRedirect(request.getContextPath() + "/reservations");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        renderPage(request, response, 3, Reservation.class, reservationBean.list(Reservation.class));
    }

}
