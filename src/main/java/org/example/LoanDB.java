package org.example;

import model.Loan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class LoanDB {
//    Save a Loan
    public static void saveLoan(Loan loan){
//      Setting up the transaction between the app and the database
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addResource("mapping.hbm.xml");
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession(); //using the session to fetch data from the database

//      Beginning the transaction with the database
        Transaction tx = session.beginTransaction();

//      Saving and closing session
        session.save(loan);
        session.getTransaction().commit();
        session.close();
        System.out.println("Loan saved");
    }

    //  Update a Loan
    public static void updateLoan(Loan loan){

//      Setting up the transaction between the app and the database
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addResource("mapping.hbm.xml");
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession(); //using the session to fetch data from the database

//      Beginning the transaction with the database
        Transaction tx = session.beginTransaction();

//      Saving and closing session
        session.saveOrUpdate(loan);
        session.getTransaction().commit();
        session.close();
        System.out.println("Loan updated");
    }

    //  Fetch an Account
    public static Loan fetchLoan(String ID){
//      Setting up the transaction between the app and the database
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addResource("mapping.hbm.xml");
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession(); //using the session to fetch data from the database
//      Beginning the transaction with the database
        Transaction tx = session.beginTransaction();

//      Fetching the account
        Loan loan = new Loan();
        loan = (Loan) session.get(Loan.class, ID);

//      Saving and closing session
        session.getTransaction().commit();
        session.close();
        return loan;
    }
}
