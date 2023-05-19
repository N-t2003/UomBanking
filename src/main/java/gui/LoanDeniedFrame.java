package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanDeniedFrame extends JFrame {

    private JFrame frame = new Template();
    private JLabel header;
    private JLabel label1;
    private JPanel innerPanel;
    private JLabel label2;
    private JLabel label3;
    private JButton loanPolicyButton;
    private JButton enterInfoAgainButton;
    private JButton returnToTheMainPageButton;


    public LoanDeniedFrame(){
        header = Utils.setHeader("Your loan request  was denied!");
        header.setBounds(300,100,900,50);

        label1 = new JLabel("Ask for a smaller amount or increase your balance");
        label1.setBounds(400, 110, 700, 100 );
        label1.setFont(new Font("Courier", Font.PLAIN, 18));

        innerPanel = new JPanel();
        innerPanel.setBounds(450, 275, 300, 200);
        innerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        label2 = new JLabel("What to do?");
        label2.setFont(new Font("Courier", Font.PLAIN, 25));

        label3 = new JLabel("Read about our loan policy and enter again your information");
        label3.setFont(new Font("Courier", Font.BOLD, 9));

        loanPolicyButton = new JButton("Loan Policy");

        loanPolicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(loanPolicyButton, "You can take a loan:\n" +
                        "1) If the amount you want is bigger than your balance*5\n" +
                        "2) You can select between 1 to 12 doses\n" +
                        "3) If you select 6 or less doses your interest is 2%, else is 4%", "INFO", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        enterInfoAgainButton = new JButton("Enter again your information");
        enterInfoAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateLoanFrame();
                frame.dispose();
            }
        });

        returnToTheMainPageButton = new JButton("Return to the main page");
        returnToTheMainPageButton.setBounds(485,650,200,35);
        returnToTheMainPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame();
                frame.dispose();
            }
        });

        frame.add(header);
        frame.add(label1);
        frame.add(innerPanel);
        frame.add(returnToTheMainPageButton);
        innerPanel.add(label2);
        innerPanel.add(label3);
        innerPanel.add(loanPolicyButton);
        innerPanel.add(enterInfoAgainButton);
        this.setContentPane(frame);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

