package model;

import java.util.ArrayList;

public class Payment extends Transaction{

    ArrayList<Type> typeList= new ArrayList<>();

    public Payment(String ID, String date, double amount, String description) {
        super(ID, date, amount, description);
    }
        
    public void printTransaction(){
            System.out.println();
    }
    

}
