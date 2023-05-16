package model;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;

import javax.persistence.*;

@Embeddable
@Entity
@Table(name = "WITHDRAW")
@PrimaryKeyJoinColumn(name = "ID")
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
