package org.example;

import model.Account;

import model.Card;


public class Test {
    public static void main(String[] args) {
//        Account account = new Account(1110222, "", "", "");
//        AccountDB.saveAccount(account);

//         Card card = new Card("",74375,"",100,"mastercard","");
//         CardDB.saveCard(card);



import model.Withdraw;
import model.Transactions;

public class Test {
    public static void main(String[] args) {
        Transactions transaction = new Withdraw("", "22", 22, "22", "22");
        TransactionsDB.saveTransaction(transaction);
        Transactions tr = TransactionsDB.fetchTransaction(transaction.getID());
        System.out.println("ID: " + tr.getID() + " Date: " + tr.getDate() + " Amount: " + tr.getAmount() + " Username: " + tr.getClientusername() + " Description: " + tr.getDescription() + " Type: " + tr.getClass().getName());

    }
}
