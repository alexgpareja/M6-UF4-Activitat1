package com.alex_gil.dao;

import com.alex_gil.model.Reserva;
import org.hibernate.SessionFactory;

public class ReservaDAO extends GenDAOImpl<Reserva> {

    public ReservaDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Reserva.class);
    }
}
