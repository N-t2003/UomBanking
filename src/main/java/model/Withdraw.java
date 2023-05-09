package model;

public class Withdraw extends Transaction{

    public Withdraw(String ID, String date, double amount, String description) {
        super(ID, date, amount, description);
    }


    @Override
    public void printTransaction() {
        super.printTransaction();
    }
}
