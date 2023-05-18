package gui;

import model.Card;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import static java.awt.Color.BLACK;

public class CreateNewCardFrame extends JFrame {

    private JFrame fr = new Template();
    private JLabel header;

    private JLabel nameLabel;
    private JTextField nameText = new JTextField();

    private JLabel typeLabel;
    private JComboBox type = new JComboBox();

    private JLabel colorLabel;
    private JPanel P = new JPanel();

    private JButton colorButton;

    private JLabel pinLabel;
    private JPasswordField pinField = new JPasswordField(4);

    private JLabel conPinLabel;
    private JPasswordField conPinField = new JPasswordField(4);

    private JButton createCardButton = new JButton("Create card");
    private JButton returnToMainPageButton = new JButton("Return to the main page");

    private JLabel message;
    public JColorChooser coChooser;


    String pin1;
    String pin2;
    Card cardDe;

    public CreateNewCardFrame() {
        this.setLayout(null);

        String[] choices = {"VISA", "MasterCard"};
        message = new JLabel("Enter 4 digits");
        message.setFont(new Font("Courier", Font.PLAIN, 10));
        header = Utils.setHeader("Enter card details");
        nameLabel = new JLabel("Name in the card");
        typeLabel = new JLabel("Type");
        final JComboBox<String> cb = new JComboBox<String>(choices);
        colorLabel = new JLabel("Color");
        pinLabel = new JLabel("Pin");
        conPinLabel = new JLabel("Confirm Pin");

        colorButton = new JButton("Choose Color");
        coChooser = new JColorChooser();
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == colorButton) {

                    Color color = coChooser.showDialog(null, "", BLACK);
                }
            }
        });

        nameLabel.setBounds(300, 200, 1000, 100);
        nameText.setBounds(400, 240, 150, 20);
        typeLabel.setBounds(370, 250, 1000, 100);
        cb.setBounds(400, 290, 150, 20);
        colorLabel.setBounds(370, 310, 1000, 100);
        colorButton.setBounds(410, 350, 100, 20);
        pinLabel.setBounds(375, 350, 1000, 100);
        pinField.setBounds(400, 390, 150, 20);
        message.setBounds(400, 405, 1000, 20);
        conPinLabel.setBounds(327, 400, 1000, 100);
        conPinField.setBounds(400, 440, 150, 20);
        createCardButton.setBounds(420, 480, 100, 20);
        returnToMainPageButton.setBounds(375, 550, 200, 20);


        createCardButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pin1 = String.valueOf(pinField.getPassword());
                pin2 = String.valueOf(conPinField.getPassword());

                if (!checkPin(pin1, pin2)) {
                    System.out.println("Enter an acceptable pin");
                }
                else
                {
                    Card card = new Card(0,"",0,0);
                    long cardNum = card.getCardNumber();
                    long cardCVV = card.getCvv();
                    String cardExp = card.getDateExp();
                    String cardName  = nameText.getText();
                    String typedText = ((JTextField)cb.getEditor().getEditorComponent()).getText();
                    //     Color cardColor = (Color) colorButton.getAction()
                    Color cardColor =  coChooser.getSelectionModel().getSelectedColor();
                    System.out.println(cardCVV +"\n"+cardNum+"\n"+cardExp);
                    System.out.println(typedText);

                    fr.dispose();
                    new PreviewCardFrame(typedText,cardNum,cardExp,cardName,cardCVV,cardColor);


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
        fr.add(colorButton);
        fr.add(conPinLabel);
        fr.add(conPinField);
        fr.add(createCardButton);
        fr.add(returnToMainPageButton);

        P.setBorder(BorderFactory.createLineBorder(BLACK));
        P.setBounds(240, 200, 700, 1);

        fr.add(P);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fr.getContentPane().setBackground(Color.LIGHT_GRAY);

    }



    public boolean checkPin(String pin1, String pin2) {

        int le1, le2;
        boolean flag1 = true;
        boolean flag2 = true;

        le1 = pin1.length();
        le2 = pin2.length();


        for (int i = 0; i < le1; i++) {
            if (!Character.isDigit(pin1.charAt(i))) {
                flag1 = false;
                break;
            }


        }

        for (int i = 0; i < le2; i++) {
            if (!Character.isDigit(pin2.charAt(i))) {
                flag2 = false;
                break;
            }

        }

        if ((le1 == 4 && le2 == 4) && (flag1 && flag2)) {
            if (pin1.equals(pin2)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }


    }
}













