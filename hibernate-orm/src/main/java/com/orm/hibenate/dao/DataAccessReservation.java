package com.orm.hibenate.dao;

import com.orm.hibenate.domain.Reservation;
import com.orm.hibenate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Environment;

import java.util.List;

public class DataAccessReservation implements ReservationDAO {

    private Transaction transaction = null;

    public void save(Reservation reservation) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects

            session.save(reservation);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    public List<Reservation> findAll() {

        List<Reservation> reservations = null ;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            reservations = session.createQuery("from Reservation ", Reservation.class).list();

            reservations.forEach(r -> System.out.println(r.getParticipant()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }


        return reservations ;
    }
}
