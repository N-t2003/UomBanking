package model;

public abstract class Transaction {

    private String ID;
    private String date;
    private double amount;
    private String description;

    public Transaction(String ID, String date, double amount, String description) {
        this.ID = ID;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public void printTransaction(){


    }
}
