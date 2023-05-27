package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Loan")
public class Loan {

    @Column(name = "LoanAmount", nullable = false, length = 20)
    private double loanAmount;
    private String dateExp; //δεν χρησιμοποιήθηκε κάπου με βάση το word
    private int doses;

    @Id
    @Column(name = "ID", nullable = false, length = 20)
    private String id;
    
    public Loan() {
    }

    public Loan(double loanAmount, String dateExp, int doses) {
        this.loanAmount = loanAmount;
        this.dateExp = dateExp;
        this.doses = doses;
    }

    public double loanDose(double loanAmount,int doses){
        double payableDose=0;
        payableDose=loanAmount/doses;


        return payableDose;
    }

    public void calculateNewLoanAmount(double loanAmaount,int doses,double balance, Account a1){
        double pDose= loanDose(loanAmount, doses);
        double newLoanAmount;
        a1.setBalance(calculateNewBalanace(balance,pDose)); 
        newLoanAmount=loanAmaount-pDose;
        setLoanAmount(newLoanAmount);
        doses--;
        setDoses(doses);
    }

    public double calculateNewBalanace(double balance,double payableDose){
            balance=balance-payableDose;  //ipologizo to kainourgio balance
            return balance;
    }



    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getDateExp() {
        return dateExp;
    }

    public void setDateExp(String dateExp) {
        this.dateExp = dateExp;
    }

    public int getDoses() {
        return doses;
    }

    public void setDoses(int doses) {
        this.doses = doses;
    }

    
    public String toString(){
        return "To poso twn dosewn pou apomenei: "+doses;
    }
    
}


