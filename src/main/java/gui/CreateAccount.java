package gui;

import model.Client;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccount extends JFrame {
    private JLabel header;
    private JLabel subHeader;
    private JPanel infoPanel;
    private JButton createAccountButton;
    private JLabel loginLabel;
    private JButton loginButton;

    public CreateAccount() {
//      Setting up the template
        JFrame createAccount = new TemplateNotLoggedIn();

//      Initializing components
        header = Utils.setHeader("Create an UoMBanking account");
        subHeader = new JLabel("Start now with our free services");
        infoPanel = new JPanel();
        createAccountButton = new JButton("Create your account");
        loginLabel = new JLabel("Already have an account?");
        loginButton = new JButton("Log in");

//      Setting up the header
        header.setBounds(250, 50, 1000, 100);

//      Setting up the subHeader
        subHeader.setBounds(450, 100, 1000, 100);
        subHeader.setFont(new Font("Courier", Font.PLAIN, 20));

//      Setting up the panel
        infoPanel = new CreateAccountPanel();

//      Adding components to the frame
        createAccount.add(header);
        createAccount.add(subHeader);
        createAccount.add(createAccountButton);
        createAccount.add(loginLabel);
        createAccount.add(loginButton);
        createAccount.add(infoPanel);

//      Basic settings
        createAccount.setLayout(null);
        createAccount.setVisible(true);
        createAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}

class CreateAccountPanel extends JPanel{
    private JCheckBox showPassword;
    private JPasswordField passwordField;
    private JPasswordField passwordField2;
    private JButton signInButton;
    private JLabel message;
    private JLabel checkLabel;
    public CreateAccountPanel() {
        showPassword = new JCheckBox("Show Password");
        passwordField = new JPasswordField(10);
        passwordField2 = new JPasswordField(10);
        signInButton = new JButton("Sign In");
        message = new JLabel("Make sure to use a strong password");
        checkLabel = new JLabel();
        checkLabel.setSize(10, 10);
        checkLabel.setIcon(Utils.setLabelIcon("src/main/java/images/Invalid.png", checkLabel));

//      Setting up the message label
        message.setFont(new Font("Courier", Font.PLAIN, 10));

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

//      Setting up the confirm password field
//        passwordField2.setEchoChar('•');
//        passwordField2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (passwordField2.getPassword().length != 0) {
//                    if (passwordField2.getText().equals(passwordField.getText())) {
//                        checkLabel.setIcon(Utils.setLabelIcon("src/main/java/images/Valid.png", checkLabel));
//                        checkLabel.setSize(10,10);
//                        checkLabel.setVisible(true);
//                    } else {
//                        checkLabel.setIcon(Utils.setLabelIcon("src/main/java/images/Invalid.png", checkLabel));
//                        checkLabel.setVisible(true);
//                        checkLabel.setSize(100,100);
//                    }
//                }
//
//            }
//        });

//      Setting up signInButton
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame();
            }
        });

//      Basic setup for the panel
        setBounds(350, 200, 500, 500);
        setBackground(Color.LIGHT_GRAY);
        Border border = BorderFactory.createTitledBorder("Information");
        setBorder(border);
        setSize(new Dimension(500, 450));
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
        add(new JLabel("First Name"), gc);

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
        add(new JLabel("Last Name"), gc);

//      Second row-Second column
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JTextField(10), gc);

//      Third row-First column
        gc.gridy++;
        gc.gridx = 0;
        gc.weighty = 0.1;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JLabel("Phone Number"), gc);

//      Third row-Second column
        gc.gridx++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JTextField(10), gc);

//      Fourth row-First column
        gc.gridy++;
        gc.gridx = 0;
        gc.weighty = 0.1;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JLabel("Email"), gc);

//      Fourth row-Second column
        gc.gridx++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JTextField(10), gc);

//      Fifth row-First column
        gc.gridy++;
        gc.gridx = 0;
        gc.weighty = 0.1;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JLabel("Password"), gc);

//      Fifth row-Second column
        gc.gridx++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(passwordField, gc);

//      Fifth row-Second column
        gc.gridx++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(showPassword, gc);

//      Sixth row-First column
        gc.gridy = gc.gridy + 2;
        gc.gridx = 0;
        gc.weighty = 0.1;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 0);
        add(message, gc);

//      Seventh row-First column
        gc.gridy++;
        gc.gridx = 0;
        gc.weighty = 0.1;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JLabel("Confirm Password"), gc);

//      Seventh row-Second column
        gc.gridx++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(passwordField2, gc);

//      Seventh row-Third column
        gc.gridx++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        checkLabel.setVisible(false);
        add(checkLabel, gc);

        return null;
    }
}

