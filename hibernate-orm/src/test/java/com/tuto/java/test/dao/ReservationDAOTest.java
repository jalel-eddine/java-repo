package com.tuto.java.test.dao;

import com.orm.hibenate.domain.Reservation;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReservationDAOTest {

    @Rule
    public final SessionFactoryRule sf = new SessionFactoryRule();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    public void save() {
        Session session = sf.getSession();
        Reservation reservation = new Reservation("Java Devloper","Eric EVANS ",
                "Microservice with DDD") ;
        session.save(reservation);
        sf.commit();

    }

    @Test
    public void findAll() {

        Reservation reservation = new Reservation("Java Devloper","Eric EVANS ",
                "Microservice with DDD") ;
        Session session = sf.getSession();

        session.save(reservation);
        List<Reservation> reservations = session.createQuery("FROM Reservation" , Reservation.class).list() ;
        sf.commit();

        List<Reservation> reservationList = new ArrayList<>() ;
        reservationList.add(reservation) ;

        assertEquals( reservationList , reservations );

    }
}