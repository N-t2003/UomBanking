package org.example;

/**
 * By the software team of UOMSystemX
 *
 */
import model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class AppClient {
    public static void main(String[] args) {
//      Setting up the transaction between the app and the database
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class);
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession(); //using the session to fetch data from the database(line 31)

        Transaction tx = session.beginTransaction();

//      Creating a new user class
        User user2 = new User();
        User user1 = new User();
//        Client cl1 = new Client("Skour", "Akis", "6097846767", "giannakiss@gmail.com",
//                "akala den menw", "malaka", "tsapou");


//      Fetching a user from the database
//        user1 = (User) session.get(User.class, 23445);
//        System.out.println(user1);

//      Adding columns to the database
        //user2.setEmail("dimsparagis@icloud.com");

//      Saving the user
//        session.save(cl1);
        session.getTransaction().commit();
        session.close();

    }

    public static void setuser(){


    }
}

