package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Deposit")
public class Deposit extends Transactions {

//  Public no arg constructor is needed for hibernate to work properly!
    public Deposit() {
    }

    public Deposit(String ID, String date, double amount, String clientusername, String description) {
        super(ID, date, amount, clientusername, description);
    }

}