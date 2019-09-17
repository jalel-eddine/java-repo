package com.tuto.java.test.dao;

import com.orm.hibenate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class SessionFactoryRule implements MethodRule {
    private SessionFactory sessionFactory;
    private Transaction transaction;
    private Session session;
    @Override
    public Statement apply(final Statement statement, FrameworkMethod method,
                           Object test) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                sessionFactory = HibernateUtil.getSessionFactory() ;
                createSession();
                beginTransaction();
                try {
                    statement.evaluate();
                } finally {
                    shutdown();
                }
            }
        };
    }
    private void shutdown() {
        try {
            try {
                try {
                    if(transaction.getStatus().isOneOf(TransactionStatus.COMMITTING))
                    transaction.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                session.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            sessionFactory.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Session createSession() {
        session = sessionFactory.openSession();
        return session;
    }
    public void commit() {
        transaction.commit();
    }
    public void beginTransaction() {
        transaction = session.beginTransaction();
    }
    public Session getSession() {
        return session;
    }
}