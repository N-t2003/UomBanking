package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRANSFER")
public class Transfer extends Transaction{

    @Column(name = "IBAN", nullable = false, length = 50)
    private String IBAN;

    public Transfer() {
    }



    public Transfer(String ID, String date, double amount,String clientusername, String description, String IBAN) {
        super(ID, date, amount,clientusername, description);
        this.IBAN = IBAN;
    }

    @Override
    public void printTransaction() {
        super.printTransaction();
    }
}
