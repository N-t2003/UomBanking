package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.ArrayList;

@Entity
@Table(name = "Payment")
public class Payment extends Transactions {

    ArrayList<Type> typeList= new ArrayList<>();

    @Column(name = "Type", nullable = false, length = 20)
    private String type;

//  Public no arg constructor is needed for hibernate to work properly!
    public Payment() {
    }

    public Payment(String ID, String date, double amount, String clientusername, String description, String type) {
        super(ID, date, amount,clientusername, description);
        this.type = type;
    }

    public void printTransaction(){
            System.out.println();
    }


    public ArrayList<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(ArrayList<Type> typeList) {
        this.typeList = typeList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
