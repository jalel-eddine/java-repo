package com.orm.hibenate.dao;


import com.orm.hibenate.domain.Reservation;

import java.util.List;

public interface ReservationDAO {
    void save(Reservation reservation) ;
    List<Reservation> findAll() ;
}
