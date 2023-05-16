package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "WITHDRAW")
public class Withdraw extends Transaction{

    public Withdraw() {
    }

    public Withdraw(String ID, String date, double amount, String description) {
        super(ID, date, amount, description);
    }


    @Override
    public void printTransaction() {
        super.printTransaction();
    }
}
