package model;

import java.util.Random;

public abstract class Transaction {

    private String ID;
    private String date;
    private double amount;
    private String description;

    public Transaction(String ID, String date, double amount, String description) {
        this.ID = genID();
        this.date = date;
        this.amount = amount;
        this.description = description;
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
