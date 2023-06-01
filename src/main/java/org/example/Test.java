package org.example;

import model.Account;

import model.Card;
import model.Client;


public class Test {
    public static void main(String[] args) {
//         Client aClient = new Client("","","","","mastercard","DVDFD");
//         ClientDB.saveClient(aClient);

//        Card aCard = new Card("",0,"",0,"","");
//        CardDB.saveCard(aCard);

        Account acc = AccountDB.fetchAccount("Skourr");
        System.out.println(acc);
    }
}
