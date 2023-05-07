package gui;

import model.Main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame {

    private JLabel logo;
    private JLabel name;
    private JLabel header;
    private JLabel signIn;
    private JPanel infoPanel;
     public WelcomePage() {
//       Setting the title of the frame
         super("Welcome to UOMSystemX");


//       Setting layout manager to null for absolute positioning
         setLayout(null);

//       Initializing components
         logo = new JLabel("Logo");
         name = new JLabel("UOMSystemX");
         header = new JLabel("Welcome to UoMBanking");
         signIn = new JLabel("Sign In");
         infoPanel = new JPanel();

//       Setting up JLabel logo
         logo.setBounds(0, 0, 150, 30);
         logo.setSize(100, 100);

         ImageIcon icon = new ImageIcon("/Users/dimsparagis/Documents/UomBankingApp/src/main/java/images/UOM_LOGO_3.png");
         Image img = icon.getImage();
         Image newImg = img.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH); //resizing the image to fit the label
         ImageIcon scaledIcon = new ImageIcon(newImg);
         logo.setIcon(scaledIcon);

//       Setting up JLabel name
         name.setBounds(10, 730, 150, 30);
         name.setFont(new Font("Courier", Font.PLAIN, 25));

//       Setting up JLabel header
         header.setBounds(350, 100, 1000, 100);
         header.setFont(new Font("Courier", Font.PLAIN, 45));

//       Setting up JLabel signIn
         signIn.setBounds(550, 300, 1000, 100);
         signIn.setFont(new Font("Courier", Font.PLAIN, 25));

//       Setting up the information panel
         infoPanel = new InfoPanel();

//       Adding components to the frame
         add(logo);
         add(name);
         add(header);
         add(signIn);
         add(infoPanel);

//       Basic setup for the frame
         setVisible(true);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setMaximumSize(new Dimension(1200, 800));
         setSize(1200, 800);
         getContentPane().setBackground(Color.LIGHT_GRAY);
         validate(); //validates the images
     }
}

class InfoPanel extends JPanel{

    private JCheckBox showPassword;
    private JPasswordField passwordField;
    private JButton signInButton;

    public InfoPanel() {
//      Initializing components
        showPassword = new JCheckBox("Show Password");
        passwordField = new JPasswordField(10);
        signInButton = new JButton("Sign In");

//      Setting up showPassword button
        passwordField.setEchoChar('•');
        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('•');
                }
            }
        });

//      Setting up signInButton
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame();
            }
        });

//      Basic setup for the panel
        setBounds(350, 400, 500, 300);
        setBackground(Color.LIGHT_GRAY);
        Border border = BorderFactory.createTitledBorder("Information");
        setBorder(border);
        setSize(new Dimension(500, 250));
        layoutComponents();
    }

    public LayoutManager layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

//      First row-First column
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Username"), gc);

//      First row-Second column
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JTextField(10), gc);

//      Second row-First column
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Password"), gc);

//      Second row-Second column
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(passwordField, gc);

//      Second row-Third column
        gc.gridx = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(showPassword, gc);

//      Third row-First column
        gc.gridy++;
        gc.gridx = 1;
        gc.weighty = 0.1;
        gc.weightx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        add(signInButton, gc);

        return null;
    }

}

