package model;

import java.util.ArrayList;

public class Payment extends Transaction{

    ArrayList<Type> typeList= new ArrayList<>();

    public Payment(String ID, String date, double amount,String clientusername, String description) {
        super(ID, date, amount,clientusername, description);
    }
        
    public void printTransaction(){
            System.out.println("Test");
    }
    

}
