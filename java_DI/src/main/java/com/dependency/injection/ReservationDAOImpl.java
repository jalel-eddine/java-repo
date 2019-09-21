package com.dependency.injection;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {

    private  List<Reservation> reservations = new ArrayList<>() ;

    @Override
    public List<Reservation> getReservations() {

        return reservations;
    }

    @Override
    public void save(Reservation reservation) {

        for (int i = 1 ; i<10 ; i++ ){
            Reservation reservation1 = new Reservation( i , reservation.getName()+i ,reservation.getDay()+i
                    , new Date("2020/"+i+"/"+i)) ;
            reservations.add(reservation1) ;
        }

    }
}
