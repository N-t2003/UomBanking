package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferFrame extends JFrame {
    private JFrame frame;
    private JLabel header;
    private JLabel ibanLabel;
    private JLabel amountLabel;
    private JTextField ibanField;
    private JTextField amountField;
    private JButton continueButton;
    private JButton returnToMainPageButton;
    private JLabel line;
    public TransferFrame(){

        frame = new Template();
        this.setLayout(null);
        ibanField = new JTextField();
        amountField = new JTextField();
        continueButton = new JButton("Continue");
        returnToMainPageButton = new JButton("Return to the main page");


        header = Utils.setHeader("Transfer money to others");
        header.setBounds(400,100,1000,100);

        line = new JLabel("____________________________________________________________________________________________________________________________");
        line.setBounds(250,150,1000,100);

        ibanLabel = new JLabel("IBAN");
        ibanLabel.setBounds(500, 300,50,50);
        ibanField.setBounds(535,315,200,25);

        amountLabel = new JLabel("Amount");
        amountLabel.setBounds(485,355,50,50);
        amountField.setBounds(535,370,200,25);


        continueButton.setBounds(570,470,120,30);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                new PreviewTransferFrame();
            }
        });

        returnToMainPageButton.setBounds(970,710,200,30);

        frame.add(header);
        frame.add(line);
        frame.add(ibanLabel);
        frame.add(ibanField);
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(continueButton);
        frame.add(returnToMainPageButton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBackground(Color.LIGHT_GRAY);

    }
}
