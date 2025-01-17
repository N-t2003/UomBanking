package gui;

import javax.swing.*;
import java.awt.*;

public class PreviewDepositFrame extends JFrame {
    private JPanel innerPanel = new JPanel();
    private JLabel header;
    private JLabel message;
    private JLabel message2;
    private JLabel balance;
    private JButton returnToMainPageButton;
    JFrame successDeposit;
    private JButton receiptButton;

    public PreviewDepositFrame(){

        successDeposit = new Template();

        //Initializing elements
        header = Utils.setHeader("Your money has been successfully deposited!");
        message = new JLabel("You have 10 days to deliver the money to the bank");
        message2= new JLabel("Your new account balance");
        balance = new JLabel("1500$");
        innerPanel = new JPanel();
        returnToMainPageButton = Utils.returnToMainPageButton(successDeposit);
        receiptButton = new JButton("Download receipt");


        //Placing the elements
        header.setBounds(300, 100, 1000, 100);
        header.setFont(new Font("Courier", Font.PLAIN, 30));

        message.setBounds(400,150,800,80);
        message.setFont(new Font("Courier", Font.PLAIN, 20));

        innerPanel.setBounds(450, 275, 300, 200);
        innerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        message2.setFont(new Font("Courier", Font.PLAIN, 25));

        balance.setFont(new Font("Courier", Font.PLAIN, 50));
        receiptButton.setBounds(380,550,200,40);

        returnToMainPageButton.setBounds(630,550,200,40);

        //Adding the elements
        innerPanel.add(message2);
        innerPanel.add(balance);
        successDeposit.add(header);
        successDeposit.add(message);
        successDeposit.add(innerPanel);
        successDeposit.add(receiptButton);
        successDeposit.add(returnToMainPageButton);

        successDeposit.setVisible(true);
        successDeposit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}



