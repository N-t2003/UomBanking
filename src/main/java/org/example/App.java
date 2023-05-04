package org.example;

/**
 * By the software team of UOMSystemX
 *
 */
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.imageio.spi.ServiceRegistry;

public class App {
    public static void main(String[] args) {
//      Setting up the transaction between the app and the database
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class);
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession(); //using the session to fetch data from the database(line 31)

        Transaction tx = session.beginTransaction();

//      Creating a new user class
        User user2 = new User();
        User user1 = new User();

//      Fetching a user from the database
        user1 = (User) session.get(User.class, 23445);
        System.out.println(user1);

//      Adding columns to the database
        user2.setEmail("dimsparagis@icloud.com");
        user2.setId(123);

//      Saving the user
        session.save(user2);
        session.getTransaction().commit();
        session.close();
    }
}

