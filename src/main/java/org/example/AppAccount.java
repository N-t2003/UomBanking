package org.example;

/**
 * By the software team of UOMSystemX
 *
 */
<<<<<<< HEAD:src/main/java/org/example/App.java
import model.Withdraw;
import org.hibernate.Hibernate;
=======
import model.Account;
import model.Client;
>>>>>>> 6d9494a33348e15da5e870cdebcaeed37487a869:src/main/java/org/example/AppAccount.java
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class AppAccount {
    public static void main(String[] args) {
//      Setting up the transaction between the app and the database
<<<<<<< HEAD:src/main/java/org/example/App.java
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
=======
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Account.class);
>>>>>>> 6d9494a33348e15da5e870cdebcaeed37487a869:src/main/java/org/example/AppAccount.java
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession(); //using the session to fetch data from the database(line 31)

        Transaction tx = session.beginTransaction();

//      Creating a new user class
<<<<<<< HEAD:src/main/java/org/example/App.java
       // User user2 = new User();
        User user1 = new User();
        Withdraw withdraw = new Withdraw("", "22", 22, "22");
=======
//        User user2 = new User();
//        User user1 = new User();
        Account acc1 = new Account(100.2,"","","Astakos");

>>>>>>> 6d9494a33348e15da5e870cdebcaeed37487a869:src/main/java/org/example/AppAccount.java

//      Fetching a user from the database
//        user1 = (User) session.get(User.class, 23445);
//        System.out.println(user1);

//      Adding columns to the database
        //user2.setEmail("dimsparagis@icloud.com");

//      Saving the user
<<<<<<< HEAD:src/main/java/org/example/App.java
        session.save(withdraw);
=======
        session.save(acc1);
>>>>>>> 6d9494a33348e15da5e870cdebcaeed37487a869:src/main/java/org/example/AppAccount.java
        session.getTransaction().commit();
        session.close();

    }

    public static void setuser(){


    }
}

