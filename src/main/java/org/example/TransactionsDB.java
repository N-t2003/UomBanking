package org.example;

import model.Account;
import model.Transactions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;

public class TransactionsDB {

//  Save a Transaction
    public static void saveTransaction(Transactions  transaction){
//      Setting up the transaction between the app and the database
        AnnotationConfiguration configuration = new AnnotationConfiguration().configure("hibernate.cfg.xml").addResource("mapping.hbm.xml");
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession(); //using the session to fetch data from the database

//      Beginning the transaction with the database
        Transaction tx = session.beginTransaction();

//      Saving and closing session
        session.save(transaction);
        session.getTransaction().commit();
        session.close();
        System.out.println("Transaction saved");
    }

    //  Update a Transaction
    public static void updateTransaction(Transactions transaction){

//      Setting up the transaction between the app and the database
        AnnotationConfiguration configuration = new AnnotationConfiguration().configure("hibernate.cfg.xml").addResource("mapping.hbm.xml");
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession(); //using the session to fetch data from the database

//      Beginning the transaction with the database
        Transaction tx = session.beginTransaction();

//      Saving and closing session
        session.saveOrUpdate(transaction);
        session.getTransaction().commit();
        session.close();
        System.out.println("Transaction updated");
    }

    //  Fetch an Account
    public static Transactions fetchTransaction(String ID){
//      Setting up the transaction between the app and the database
        AnnotationConfiguration configuration = new AnnotationConfiguration().configure("hibernate.cfg.xml").addResource("mapping.hbm.xml");
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession(); //using the session to fetch data from the database
//      Beginning the transaction with the database
        Transaction tx = session.beginTransaction();

//      Fetching the account
        Transactions transaction = new Transactions();
        transaction = (Transactions) session.get(Transactions.class, ID);

//      Saving and closing session
        session.getTransaction().commit();
        session.close();
        return transaction;
    }
}
