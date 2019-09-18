package com.jpa.hibernate.dao;


import com.jpa.hibernate.domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public interface CustomerDAO {
    void save(Customer customer) ;
    List<Customer> findAll() ;
    Customer getOneById(Long id) ;
    Customer getOneByName(String name);
    EntityManagerFactory getFactory() ;
    EntityManager getEm() ;
}
