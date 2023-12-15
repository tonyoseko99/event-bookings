package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.entity.Reservation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ReservationBean extends GenericBean<Reservation> implements ReservationI {

    @PersistenceContext
    private EntityManager database;
    
    @Override
    public Reservation findById(Long id) {
        return database.find(Reservation.class, id);
    }

}
