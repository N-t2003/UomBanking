package gui;

import javax.swing.*;
import java.awt.*;

public class PreviewDepositFrame extends JFrame {
    private Template template;
    private JLabel header;
    private JLabel message;
    private JLabel message2;
    private JLabel balance;

    public PreviewDepositFrame(){

        JFrame successDeposit = new Template();
        header = Utils.setHeader("Your money has been successfully deposited!");
        message = Utils.setHeader("You have 10 days to deliver the money to the bank");
        message2= Utils.setHeader("Your new account balance");


        this.setContentPane(template);

        successDeposit.add(header);
        successDeposit.add(message);
        successDeposit.add(message2);
        successDeposit.add(balance);

        successDeposit.setVisible(true);
        successDeposit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        successDeposit.getContentPane().setBackground(Color.LIGHT_GRAY);

    }


}



