package model;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;

import javax.persistence.*;

@Entity
@Table(name = "Withdraw")
@DiscriminatorValue(value = "Withdraw")
public class Withdraw extends Transaction{


    public Withdraw() {
    }


    public Withdraw(String ID, String date, double amount,String clientusername, String description) {
        super(ID, date, amount,clientusername, description);
    }


    @Override
    public void printTransaction() {
        super.printTransaction();
    }
}
