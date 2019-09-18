package com.java.spring.dao;


import com.java.spring.domain.Reservation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationDataAccess implements ReservationDAO {

    @Override
    public Reservation getReservation() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml") ;
         Reservation reservation = (Reservation) context.getBean("Reservation");
        return reservation;
    }
}
