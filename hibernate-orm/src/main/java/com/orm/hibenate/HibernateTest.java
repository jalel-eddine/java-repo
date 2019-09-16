package com.orm.hibenate;

import com.orm.hibenate.dao.ReservationDAO;
import com.orm.hibenate.dao.DataAccessReservation;
import com.orm.hibenate.domain.Reservation;

public class HibernateTest {
    public static void main(String[] args) {

        ReservationDAO reservationDAO = new DataAccessReservation();
        reservationDAO.save(new Reservation("Java Devloper","Eric EVANS ","Microservice with DDD") );
        reservationDAO.save(new Reservation("Java Devloper","Vaughn Vernon","Reactive DDD") );

        reservationDAO.findAll().forEach(r ->{
            System .out .println(r.toString()) ;
            System.out.println("_______________________________________________________________________");
        });

    }
}

