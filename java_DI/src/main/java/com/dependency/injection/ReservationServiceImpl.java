package com.dependency.injection;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    private ReservationDAO reservationDAO ;

    public void setReservationDAO(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    @Override
    public List<Reservation> save(Reservation reservation) {
       // Assert.checkNonNull(reservation , " Can not add empty reservation ") ;
        reservationDAO.save(reservation);
        return reservationDAO.getReservations();
    }
}
