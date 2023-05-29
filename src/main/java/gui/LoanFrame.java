package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanFrame extends JFrame {

    private JLabel header;

    private JLabel message;

    private JLabel message1;

    private JButton NewLoan;

    private JButton ReturnToTheMainPage;

    private JTable LoanTable;

    private JButton loanReceipt;



    public LoanFrame(){

        JFrame Loans = new Template();

        header = Utils.setHeader("Take loans with our bank system!");
        message = new JLabel("Manage and pay your loans fast and easy");
        message1 = new JLabel("Your loans");
        NewLoan = new JButton("New Loan");
        ReturnToTheMainPage = new JButton("Return to the main page");
        loanReceipt = new JButton("Download loan receipt");


        String[] LoansColumns = new String[]{"Amount", "Expiration Date"};
        String[][] LoansInfo = new String[][]{{"1000$","1/6/23"},{"90$","3/3/23"},{"250$","9/10/23"}};

        LoanTable = new JTable(LoansInfo,LoansColumns);
        JScrollPane jp = new JScrollPane(LoanTable);
        jp.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        LoanTable.setForeground(Color.BLACK);
        LoanTable.setEnabled(false);


        header.setBounds(320, 100, 800, 100);
        header.setFont(new Font("Courier",Font.PLAIN,35));

        message.setBounds(400,140,600,80);
        message.setFont(new Font("Courier",Font.PLAIN,20));

        message1.setBounds(520,300,500,60);
        message1.setFont(new Font("Courier", Font.PLAIN,30));

        ReturnToTheMainPage = Utils.returnToMainPageButton(Loans);
        ReturnToTheMainPage.setBounds(1000,710,180,30);

        loanReceipt.setBounds(480,680,200,30);

        NewLoan.setBounds(500,580,150,30);

        jp.setBounds(440,360,300,130);



        NewLoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateLoanFrame();
            }
        });

        Loans.add(header);
        Loans.add(message);
        Loans.add(message1);
        Loans.add(ReturnToTheMainPage);
        Loans.add(NewLoan);
        Loans.add(loanReceipt);
        Loans.add(jp);
        Loans.setVisible(true);
        Loans.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Loans.getContentPane().setBackground(Color.LIGHT_GRAY);
    }
}