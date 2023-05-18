package gui;

import model.Transaction;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TransactionHistoryFrame extends JFrame {
    private JButton returnToMainPageButton;
    private JLabel header;
    private JLabel subheader;
    private JFrame frame = new Template();



    public TransactionHistoryFrame(){

        header = Utils.setHeader("Transaction history");
        subheader = new JLabel("See what you spend in detail");

        Transaction[][] trans = new Transaction[3][3];
        String[] column={"Transaction","Amount","Date"};


        JTable jt = new JTable(trans,column);
        JScrollPane sc = new JScrollPane(jt);
        jt.setEnabled(false);
        sc.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        jt.setForeground(Color.BLACK);
        frame.add(sc);



        header.setBounds(400,100,1000,100);
        subheader.setBounds(500,140,1500,100);
        sc.setBounds(320,250,500,100);



        frame.add(header);
        frame.add(subheader);
        frame.add(sc);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

    }

}
