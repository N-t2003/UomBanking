package gui;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoanSuccessFrame extends JFrame{
    private JFrame frame = new Template();
    private JLabel header;
    private JLabel label1;
    private JLabel label2;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton returnToTheMainPageButton;

    public LoanSuccessFrame() {

        header = Utils.setHeader("Your loan was made successfully!");
        header.setBounds(300,100,900,50);

        label1 = new JLabel("Make sure to pay it off by <Date>");
        label1.setBounds(500, 110, 700, 100 );

        label2 = new JLabel("Your loans");
        label2.setBounds(500, 250, 1000, 100 );
        label2.setFont(new Font("Courier", Font.PLAIN, 30));

        returnToTheMainPageButton = new JButton("Return to the main page");
        returnToTheMainPageButton.setBounds(485,650,200,35);

        Object rowData[][] = new Object[4][2];
        String columnNames[] = { "Amount", "Expiration Date"};

        table= new JTable(rowData, columnNames);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(270,350,600,100);
        table.setEnabled(false);

        returnToTheMainPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame();
                frame.dispose(); //με το που πατάμε το κουμπί ανοίγει το MainFrame και κλείνει το παράθυρο των δανείων.
            }
        });

        frame.add(header);
        frame.add(label1);
        frame.add(label2);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(returnToTheMainPageButton);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //ΛΕΙΠΕΙ Η ΜΕΘΟΔΟΣ calcDate

}
