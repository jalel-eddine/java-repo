package com.dependency.injection;

import java.lang.reflect.Method;
import java.util.Date;

public class JavaMutableDI {


    public static void main( String[] args ) {


        try {



            Class reservationServiceClass =  Class.forName("com.dependency.injection.ReservationServiceImpl" , true, JavaMutableDI.class.getClassLoader());
            Class reservationDAOClass = Class.forName("com.dependency.injection.ReservationDAOImpl", true, JavaMutableDI.class.getClassLoader()) ;

            ReservationService reservationService = (ReservationService) reservationServiceClass.newInstance();
            ReservationDAO reservationDAO = (ReservationDAO) reservationDAOClass.newInstance();

            Method method = reservationServiceClass.getMethod("setReservationDAO" , new Class[] {ReservationDAO.class}) ;
            method.invoke(reservationService , new Object []{ reservationDAO} ) ;

            reservationService.save(new Reservation("someOne",10, new Date())).forEach(r ->{
                System.out.println(r);
            });

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
