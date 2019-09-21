package com.dependency.injection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaMutableDITest {

    @Mock
    ReservationDAOImpl reservationDAO ;

    @InjectMocks
    ReservationServiceImpl reservationService ;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        Mockito
                .when(reservationDAO.getReservations()).thenReturn(getListTest()) ;
    }


    @Test
    void testDependencyInjection(){
        List<Reservation> reservations = reservationService.save(new Reservation("someOne",10, new Date())) ;

        assertEquals(9,reservations.size());
        assertEquals(13,reservations.get(2).getDay());
    }

    List<Reservation> getListTest(){
        List<Reservation> reservations = new ArrayList<>() ;
        Reservation reservation = new Reservation("someOne",10, new Date()) ;
        for (int i = 1 ; i<10 ; i++ ){
            Reservation reservation1 = new Reservation( i , reservation.getName()+i ,reservation.getDay()+i
                    , new Date("2020/"+i+"/"+i)) ;
            reservations.add(reservation1) ;
        }

        return reservations ;
    }
}