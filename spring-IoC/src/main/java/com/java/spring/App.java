package com.java.spring;

import com.java.spring.dao.ReservationDAO;
import com.java.spring.dao.ReservationDataAccess;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App {

    public static void main( String[] args ) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ReservationDAO reservationDAO = (ReservationDAO) context.getBean("ReservationDataAccess");

        System.out.println("-------------------------------------");
        System.out.println(reservationDAO.getReservation());

    }
}
