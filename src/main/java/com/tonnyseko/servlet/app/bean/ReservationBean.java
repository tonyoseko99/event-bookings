package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.entity.Address;
import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.model.entity.Reservation;
import com.tonnyseko.servlet.app.model.entity.User;

import javax.ejb.Stateless;

@Stateless
public class ReservationBean extends GenericBean<Reservation> implements ReservationI {
}
