package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PaymentFrame extends JFrame {
    private JLabel header;
    private JLabel message;
    private JLabel IBANLabel;
    private JTextField IBANField;
    private JLabel amountLabel;
    private JTextField amountField;
    private JLabel expensesLabel;
    private JButton submitButton;
    private JButton returnToMainPageButton;
    private String[] expenses = {"Groceries","Health","Transport"};
    public PaymentFrame(){
        JFrame payment = new Template();
        JComboBox<String> cb = new JComboBox<String>(expenses);

        //Initializing elements
        header = Utils.setHeader("Make your own expenses with our app");
        message = new JLabel("Shops, Pharmacies and more!");
        IBANLabel =new JLabel("IBAN");
        IBANField = new JTextField();
        amountLabel = new JLabel("Amount");
        amountField = new JTextField();
        expensesLabel = new JLabel("Type of expense");
        submitButton = new JButton("Submit");
        returnToMainPageButton = new JButton("Return to the main page");

        //Placing the elements
        header.setBounds(325, 100, 1000, 100);
        header.setFont(new Font("Courier", Font.PLAIN, 30));

        message.setBounds(450,150,800,80);
        message.setFont(new Font("Courier", Font.PLAIN, 20));

        IBANLabel.setBounds(470, 290,50,50);
        IBANField.setBounds(500,300,200,35);

        amountLabel.setBounds(455,350,50,50);
        amountField.setBounds(500,360,200,35);

        expensesLabel.setBounds(400,420,100,50);
        cb.setBounds(500,430,150,35);

        submitButton.setBounds(570,600,80,35);
        returnToMainPageButton.setBounds(950,700,200,35);

        //Action Listeners
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //checkAmount();
            }
        });


        //Adding the elements
        payment.add(header);
        payment.add(message);
        payment.add(IBANLabel);
        payment.add(IBANField);
        payment.add(amountLabel);
        payment.add(amountField);
        payment.add(expensesLabel);
        payment.add(cb);
        payment.add(submitButton);
        payment.add(returnToMainPageButton);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void checkAmount(double amount, double balance){


    }
}

