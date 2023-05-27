package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

// ΔΕΝ ΕΧΕΙ ΥΛΟΠΟΙΗΘΕΙ Ο ΤΥΠΟΣ ΤΗΣ ΚΑΡΤΑΣ
@Entity
@Table(name = "Card")
public class Card{

    @Id
    @Column(name = "CardNumber", nullable = false, length = 20)
    private long cardNumber;

    @Column(name = "DateExpire", nullable = false, length = 10)
    private String dateExp;

    @Column(name = "CVV", nullable = false, length = 3)
    private long cvv;

    @Column(name = "Type", nullable = false, length = 15)
    private int type;

    @Column(name = "Color", nullable = false, length = 20)
    private String color;

    
    public Card(){

    }
    
    public Card(long cardNumber, String dateExp, long cvv, int type, String color) {
        this.cardNumber = genNum();
        this.dateExp = genDateExp();
        this.cvv = genCVV();
        this.type = type;
        this.color = color;
    }

    

    public long genNum() {
        long smallest = 1000_0000_0000_0000L;
        long biggest =  9999_9999_9999_9999L;

        // return a long between smallest and biggest (+1 to include biggest as well with the upper bound)
         long random = ThreadLocalRandom.current().nextLong(smallest, biggest+1);
        return random;
    }

    public long genCVV(){
        long smallest = 100L;
        long biggest =  999L;

        // return a long between smallest and biggest (+1 to include biggest as well with the upper bound)
         long random = ThreadLocalRandom.current().nextLong(smallest, biggest+1);
        return random;
    }

    public String genDateExp(){
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat formatMonth = new SimpleDateFormat("MM");  
        Date date = new Date(); 
        int currentYear=Integer.parseInt(formatYear.format(date));  
        int expYear;
        expYear= currentYear+5;
        String expDate=Integer.toString(expYear);
        expDate=formatMonth.format(date)+"/"+expDate;
        return expDate;
    }


    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    
    public long getCvv() {
        return cvv;
    }

    public void setCvv(long cvv) {
        this.cvv = cvv;
    }

    public String getDateExp() {
        return dateExp;
    }
    public void setDateExp(String dateExp) {
        this.dateExp = dateExp;
    }
    
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public String toString() {
        return "This is the number of your Card: "+cardNumber+"\n"+"This is you CVV: "+cvv+"\n"+"Your Expiration Date is: "+genDateExp();
    }

    

    

    

    

    

    

    



    



    

}
