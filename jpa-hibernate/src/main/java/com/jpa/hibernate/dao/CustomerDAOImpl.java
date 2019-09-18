package com.jpa.hibernate.dao;

import com.jpa.hibernate.domain.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private  EntityManagerFactory factory = Persistence.createEntityManagerFactory("up_customer");
    private  EntityManager em = factory.createEntityManager() ;

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public EntityManager getEm() {
        return em;
    }

    @Override
    public void save(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = em.createQuery("FROM Customer" , Customer.class).getResultList() ;
        return customers ;
    }

    @Override
    public Customer getOneById(Long id) {
        Customer customers = em.find(Customer.class, id );
        return customers;
    }

    @Override
    public Customer getOneByName(String name) {
        Query query = em.createQuery("select c from Customer c where  c.name = :x");
        query.setParameter("x", name);
        Customer customer = (Customer) query.getSingleResult();
        return customer;
    }
}
