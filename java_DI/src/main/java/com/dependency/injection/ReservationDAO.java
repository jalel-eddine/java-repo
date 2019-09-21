package com.dependency.injection;


import java.util.List;

public interface ReservationDAO {

    List<Reservation> getReservations() ;
    void save(Reservation reservation) ;
}
