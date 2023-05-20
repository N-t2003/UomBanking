package org.example;

/**
 * By the software team of UOMSystemX
 *
 */
import model.Withdraw;
import org.hibernate.*;
import model.Account;
import model.Client;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class AppAccount {
    public static void main(String[] args) {
//      Setting up the transaction between the app and the database
        AnnotationConfiguration configuration = new AnnotationConfiguration().configure("hibernate.cfg.xml").addResource("mapping.hbm.xml");
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession(); //using the session to fetch data from the database(line 31)

        Transaction tx = session.beginTransaction();

//      Creating a new user class

//        User user1 = new User();
        Account acc1 = new Account(100.2,"","","Astakos");
        Withdraw withdraw = new Withdraw("", "22", 22, "22", "22");

//        Client cl1 = new Client("1", "1", "1", "1",
//                "1", "232", "1");

//      Fetching a user from the database
//        user1 = (User) session.get(User.class, 23445);
//        System.out.println(user1);

//      Adding columns to the database
        //user2.setEmail("dimsparagis@icloud.com");

//      Saving the user
        session.save(acc1);
        session.save(withdraw);
        session.getTransaction().commit();
        session.close();

    }
}

