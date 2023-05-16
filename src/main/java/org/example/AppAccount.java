package org.example;

/**
 * By the software team of UOMSystemX
 *
 */
import org.hibernate.*;
import model.Account;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class AppAccount {
    public static void main(String[] args) {
//      Setting up the transaction between the app and the database
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Account.class);
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession(); //using the session to fetch data from the database(line 31)

        Transaction tx = session.beginTransaction();



      //  Account acc1 = new Account(100.2,"","","sleeeeeet");


//      Fetching a user from the database
//          Account acc2 = (Account) session.get(Account.class, "*zk4E+yJ");
         // System.out.println(session.get(Account.class, "*zk4E+yJ"));

//      Adding columns to the database
        //user2.setEmail("dimsparagis@icloud.com");

//      Saving the user

        Account account = (Account) session.get(Account.class, "*zk4E+yJ");


        if (account != null) {
           // System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Balance: " + account.getBalance() + account.getIBAN());
            // Print other account properties as needed
        } else {
            System.out.println("Account not found.");
        }

       // session.save(acc2);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public static void setuser(){


    }
}

