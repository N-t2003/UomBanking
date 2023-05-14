package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

    public class CreateNewCardFrame extends JFrame {

        private JFrame fr = new Template();
        private JLabel header;
        private JLabel nameLabel;
        private JTextField nameText = new JTextField();

        private JLabel typeLabel;
        private JComboBox type = new JComboBox();

        private JLabel colorLabel;

        private JLabel pinLabel;
        private JPasswordField pinField = new JPasswordField(4);

        private JLabel conPinLabel;
        private JPasswordField conPinField = new JPasswordField(4);

        private JButton createCardButton = new JButton("Create card");
        private JButton returnToMainPageButton = new JButton("Return to the main page");

        private JLabel message;

        String pin1 = pinField.getText();
        String pin2 = conPinField.getText();


        public CreateNewCardFrame() {
            String[] choices = {"VISA", "MasterCard", "PrePaid"};
            message = new JLabel("Enter 4 digits");
            message.setFont(new Font("Courier", Font.PLAIN, 10));


            header = Utils.setHeader("Enter card details");
            nameLabel = new JLabel("Name in the card");
            typeLabel = new JLabel("Type");
            final JComboBox<String> cb = new JComboBox<String>(choices);
            colorLabel = new JLabel("Color");
            pinLabel = new JLabel("Pin");
            conPinLabel = new JLabel("Confirm Pin");

            nameLabel.setBounds(300, 150, 1000, 100);
            nameText.setBounds(400, 190, 150, 20);
            typeLabel.setBounds(370, 200, 1000, 100);
            cb.setBounds(400, 240, 150, 20);
            colorLabel.setBounds(370, 280, 1000, 100);
            pinLabel.setBounds(375, 320, 1000, 100);
            pinField.setBounds(400, 360, 150, 20);
            message.setBounds(400, 380, 1000, 20);
            conPinLabel.setBounds(327, 370, 1000, 100);
            conPinField.setBounds(400, 410, 150, 20);
            createCardButton.setBounds(420, 450, 100, 20);
            returnToMainPageButton.setBounds(375, 550, 200, 20);

            createCardButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if(checkPin(pin1,pin2)){
                        dispose();
                        new PreviewCardFrame();
                    }
                    else{
                        System.out.println("Enter an acceptable pin");
                    }
                }
            });

            setBackground(Color.LIGHT_GRAY);


            fr.add(header);
            fr.add(nameLabel);
            fr.add(nameText);
            fr.add(typeLabel);
            fr.add(cb);
            fr.add(pinLabel);
            fr.add(pinField);
            fr.add(message);
            fr.add(colorLabel);
            fr.add(conPinLabel);
            fr.add(conPinField);
            fr.add(createCardButton);
            fr.add(returnToMainPageButton);




            fr.setVisible(true);
            fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
            fr.getContentPane().setBackground(Color.LIGHT_GRAY);

        }


        public boolean checkPin(String pin1, String pin2) {
            int le1 = 0;
            int le2 = 0;

            boolean flag1 = true;
            boolean flag2 = true;

            le1 = pinField.getText().length();
            le2 = conPinField.getText().length();

            for (int i = 0; i < le1; i++) {
                if (!Character.isDigit(pinField.getText().charAt(i))) {
                    flag1 = false;
                    break;
                }

            }

            for (int i = 0; i < le2; i++) {
                if (!Character.isDigit(conPinField.getText().charAt(i))) {
                    flag2 = false;
                    break;
                }

            }

            if (le1 == le2 & flag1 & flag2 & pin1.equals(pin2))
                return true;
            else
                return false;

        }

        }



