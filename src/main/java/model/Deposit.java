package model;

public class Deposit extends Transaction{

    public Deposit(String ID, String date, double amount, String description) {
        super(ID, date, amount, description);
    }

    public void printTransaction(){
        System.out.println("ID: "+getID()+"\n"+"Date: "+getDate()+"\n"+"Amount: "+getAmount()+"\n"+
        "Description: "+getDescription());
    }










}