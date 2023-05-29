package org.example;

import model.Account;

public class Test {
    public static void main(String[] args) {
        Account account = new Account(1110, "", "", "");
        AccountDB.saveAccount(account);
    }
}
