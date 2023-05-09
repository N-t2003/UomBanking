
package model;

import java.util.Random;
import java.util.ArrayList;
public abstract class Account {

    private double balance;
    private String ID;
    private int IBAN;
    private Client client;
    private ArrayList<Transaction> tList = new ArrayList<>(); //λίστα που περιέχει transactions
    private ArrayList<Loan> lList = new ArrayList<>(); //λίστα που περιέχει Loans

    public Account(double balance, int IBAN, int ID, Client client) {
        this.balance = balance;
        this.IBAN = IBAN;
        this.ID = genID();
        this.client = client;
    }

    public void tList(Transaction trans){

        tList.add(trans); //προσθήκη ενός transaction στην λίστα
    }

    public void tList(Loan loan){

        lList.add(loan); //προσθήκη ενός loan στην λίστα
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


    public ArrayList<Transaction> printTList() {
        return tList;
    }

    public ArrayList<Loan> printLList() {
        return lList;
    }


}

