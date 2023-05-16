package model;

import jakarta.persistence.*;

import java.util.Random;


@Entity
@Table(name = "Transactions")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Transaction {

    @Id
    @Column(name = "ID", nullable = false, length = 50)
    private String ID;

    @Column(name = "DATE", nullable = false, length = 50)
    private String date;

    @Column(name = "AMOUNT", nullable = false, length = 50)
    private double amount;

    @Column(name = "DESCRIPTION", nullable = false, length = 50)
    private String description;

    @Column(name = "ClientUsername", nullable = false, length = 50)
    private String clientusername;                                     // χρησιμοποιείται για να ξέρουμε ποιανού το transaction είναι

    public Transaction() {

    }


    public Transaction(String ID, String date, double amount, String description, String clientusername) {
        this.ID = genID();
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.clientusername = clientusername;
    }




    public double calculateNewBalance(double balance, double amount){

        balance += amount;

        return balance ;
    }


    public String genID(){
        //Δημιουργία ενός τυχαίου ID με 8 χαρακτήρες π.χ. kHFujh%4
        String characters ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        int length = 8;
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            builder.append(characters.charAt(index));
        }
        return builder.toString();

    }



    public void printTransaction(){


    }
}
