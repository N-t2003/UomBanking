package model;

public class Transfer extends Transaction{

    private String IBAN;

    public Transfer(String ID, String date, double amount, String description, String IBAN) {
        super(ID, date, amount, description);
        this.IBAN = IBAN;
    }

    @Override
    public void printTransaction() {
        super.printTransaction();
    }
}
