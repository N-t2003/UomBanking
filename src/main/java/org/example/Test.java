package org.example;

import model.Account;
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
