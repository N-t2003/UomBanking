package gui;

import model.Client;

import javax.swing.*;
import java.awt.*;

public class Template extends JFrame {

//  Properties
    private JLabel logo;
    private JLabel name;
    private JLabel accountIcon;
    private JLabel clientName;

    public Template() {
//      Setting layout manager to null for absolute positioning
        setLayout(null);

//      Initializing components
        logo = new JLabel("Logo");
        name = new JLabel("UOMSystemX");
        accountIcon = new JLabel("Account");
        clientName = new JLabel();

//      Setting up JLabel logo
        logo.setBounds(0, 0, 150, 30);
        logo.setSize(100, 100);

        ImageIcon icon = new ImageIcon("/Users/dimsparagis/Documents/UomBankingApp/src/main/java/images/UOM_LOGO_3.png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH); //resizing the image to fit the label
        ImageIcon scaledIcon = new ImageIcon(newImg);
        logo.setIcon(scaledIcon);

//      Setting up JLabel accountIcon
        accountIcon.setBounds(1130, 10, 150, 30);
        accountIcon.setSize(50, 50);

        ImageIcon icon2 = new ImageIcon("/Users/dimsparagis/Documents/UomBankingApp/src/main/java/images/UserIcon.png");
        Image img2 = icon2.getImage();
        Image newImg2 = img2.getScaledInstance(accountIcon.getWidth(), accountIcon.getHeight(), Image.SCALE_SMOOTH); //resizing the image to fit the label
        ImageIcon scaledIcon2 = new ImageIcon(newImg2);
        accountIcon.setIcon(scaledIcon2);


//      Setting up JLabel name
        name.setBounds(10, 730, 150, 30);
        name.setFont(new Font("Courier", Font.PLAIN, 25));

//      Setting up JLabel clientName
        clientName.setBounds(1115, 65, 150, 30);
        clientName.setFont(new Font("Courier", Font.PLAIN, 15));
        Client testClient = new Client("Dimitris", "Sparagis", 694, "", "", "", "");
        clientName.setText(testClient.getFirstName());


//      Adding components to the frame
        add(logo);
        add(name);
        add(accountIcon);
        add(clientName);

//      Basic setup for the frame
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(1200, 800));
        setSize(1200, 800);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        validate(); //validates the images
    }
}
