package com.example.dao;


import com.example.model.Customer;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerRepository {

    public List<Customer> getAllCustomers() {
        Transaction transaction = null;
        List<Customer> customers = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            customers = session.createQuery("from Customer", Customer.class).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return customers;
    }
}
