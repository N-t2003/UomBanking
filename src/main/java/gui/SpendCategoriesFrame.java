package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpendCategoriesFrame extends JFrame {

    private JLabel header;

    private JLabel message;

    private JButton ReturnToTheMainPage;

    private JTable SCTable;



    public SpendCategoriesFrame(){

        JFrame SpendCategories = new Template();

        header = Utils.setHeader("Spend Categories");
        message = new JLabel("See what you spend in each category");
        ReturnToTheMainPage = new JButton("Return to the main page");

        String[] Columns = new String[]{"Transaction", "Amount"};
        String[][] SCInfo = new String[][]{{"Supermarket","190.80$"},{"Pharmacy","380.76$"},{"Transport","100$"}};

        SCTable = new JTable(SCInfo,Columns);
        JScrollPane jp = new JScrollPane(SCTable);
        jp.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        SCTable.setForeground(Color.BLACK);
        SCTable.setEnabled(false);


        header.setBounds(440, 100, 800, 100);
        header.setFont(new Font("Courier",Font.PLAIN,40));

        message.setBounds(480,140,600,80);
        message.setFont(new Font("Courier",Font.PLAIN,15));

        ReturnToTheMainPage.setBounds(530,440,180,30);

        ReturnToTheMainPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new MainFrame();
            }
        });

        jp.setBounds(440,280,350,130);








        SpendCategories.add(header);
        SpendCategories.add(message);
        SpendCategories.add(ReturnToTheMainPage);
        SpendCategories.add(jp);
        SpendCategories.setVisible(true);
        SpendCategories.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SpendCategories.getContentPane().setBackground(Color.LIGHT_GRAY);





    }

}