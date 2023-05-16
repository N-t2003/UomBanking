
package model;

import org.example.AppAccount;

import javax.persistence.*;
import java.util.Random;
import java.util.ArrayList;
@Entity
@Table(name = "Account")
public class Account {

    @Column(name = "balance", nullable = false, length = 50)
    private double balance;

    @Id
    @Column(name = "ID", nullable = false, length = 8)
    private String ID;

    @Column(name = "IBAN", nullable = false, length = 27)
    private String IBAN;

    @Column(name = "clientUsername", nullable = false, length = 27)
    private String client;


    @Transient
    private ArrayList<Transaction> tList = new ArrayList<>(); //λίστα που περιέχει transactions
    @Transient
    private ArrayList<String> lList = new ArrayList<String>(); //λίστα που περιέχει Loans

    public Account() {

    }

    public Account(double balance, String IBAN, String ID, String client) {
        this.balance = balance;
        this.IBAN = genIBAN();
        this.ID = genID();
        this.client = client;
        System.out.println(this.IBAN);
    }

    public void tList(Transaction trans){

        tList.add(trans); //προσθήκη ενός transaction στην λίστα
    }

    public void tList(String loan){

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

    public String genIBAN(){
        String characters = "0123456789";
        int length = 27;

        Random random = new Random();
        StringBuilder builder = new StringBuilder(length);

        // Append "GR" to the beginning of the string
        builder.append("GR00");

        for (int i = 0; i < length - 4; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            builder.append(randomChar);
        }

        return builder.toString();

    }


    public ArrayList<Transaction> printTList() {
        return tList;
    }

    public ArrayList<String> printLList() {
        return lList;
    }




    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", ID='" + ID + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", client='" + client + '\'' +
                '}';
    }


    //get and set\\

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getID() {
        return ID;
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getClient() {
        return client;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void settList(ArrayList<Transaction> tList) {
        this.tList = tList;
    }

    public void setlList(ArrayList<String> lList) {
        this.lList = lList;
    }
}

