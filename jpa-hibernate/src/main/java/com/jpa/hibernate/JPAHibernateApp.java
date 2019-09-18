package com.jpa.hibernate;

import com.jpa.hibernate.dao.CustomerDAO;
import com.jpa.hibernate.dao.CustomerDAOImpl;
import com.jpa.hibernate.domain.Customer;

public class JPAHibernateApp {
    public static void main(String[] args) {

        CustomerDAO customerDAO = new CustomerDAOImpl();
        customerDAO.save(new Customer("customer_1","customer_1@customer.com") );
        customerDAO.save(new Customer("customer_2","customer_2@customer.com") );
        customerDAO.save(new Customer("customer_3","customer_3@customer.com") );
        customerDAO.save(new Customer("customer_4","customer_4@customer.com") );
        customerDAO.save(new Customer("customer_8","customer_5@customer.com") );

        System.out.println("_______________________________________________________________________");
        customerDAO.findAll().forEach(r ->{

            System .out .println(r.toString()) ;

        });


        System.out.println("_______________________________________________________________________");
        System.out.println(customerDAO.getOneById(1L)) ;
        System.out.println("_______________________________________________________________________");
        System.out.println(customerDAO.getOneByName("customer_3")) ;

        customerDAO.getEm().close();
        customerDAO.getFactory().close();
    }
}

