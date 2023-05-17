package gui;

import javax.swing.*;
import java.awt.*;

public class PreviewPaymentFrame extends JFrame {
    private JPanel innerPanel = new JPanel();
    private JLabel header;
    private JLabel message;
    private JLabel message2;
    private JLabel balance;
    private JButton returnToMainPageButton;

    public PreviewPaymentFrame() {

        JFrame successPayment= new Template();

        //Initializing elements
        header = Utils.setHeader("Your payment was made successfully!");
        message = new JLabel("Your new account balance");
        balance = new JLabel("1500$");
        innerPanel = new JPanel();
        returnToMainPageButton = new JButton("Return to the main page");


        //Placing the elements
        header.setBounds(330, 100, 1000, 100);
        header.setFont(new Font("Courier", Font.PLAIN, 30));

        innerPanel.setBounds(450, 275, 300, 200);
        innerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        message.setFont(new Font("Courier", Font.PLAIN, 25));

        balance.setFont(new Font("Courier", Font.PLAIN, 50));

        returnToMainPageButton.setBounds(500, 550, 200, 35);

        //Adding the elements
        innerPanel.add(message);
        innerPanel.add(balance);
        successPayment.add(header);
        successPayment.add(innerPanel);
        successPayment.add(returnToMainPageButton);

        this.setContentPane(successPayment);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
    }
}

