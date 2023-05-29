package org.example;

import model.Account;

import model.Card;


public class Test {
    public static void main(String[] args) {
         Card card = new Card("",0,"",0,"mastercard","");
         CardDB.saveCard(card);
    }
}
