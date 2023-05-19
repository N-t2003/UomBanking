package gui;

import model.Card;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static java.awt.Color.BLACK;
import static java.awt.Color.getColor;

public class CreateNewCardFrame extends JFrame {

    private JFrame fr = new Template();
    private JLabel header;
    private JLabel nameLabel; //θα φιλοξενήσει το όνομα
    private JTextField nameText = new JTextField();
    private JLabel typeLabel;
    private JComboBox type = new JComboBox(); //για την επιλογη του τυπυ της καρτας
    private JLabel colorLabel; //θα φιλοξενήσει το χρώμα
    private JButton colorButton; //κουμπί για αλλαγή χρώματος
    private JLabel pinLabel; //θα φιλοξενήσει το πιν
    private JPasswordField pinField = new JPasswordField(4);
    private JLabel conPinLabel;
    private JPasswordField conPinField = new JPasswordField(4);
    private JButton createCardButton = new JButton("Create card");//κουμπί για δημιουργία κάρτας
    private JButton returnToMainPageButton = new JButton("Return to the main page");//κουμπί για επιστροφή στο αρχικό μενού
    private JLabel message; //υπενθύμιση για πιν
    private JPanel chipPanel = new JPanel(); //υποθετικό τσιπ κάρτας
    public JColorChooser coChooser; //για επιλογή χρώματος
    private JLabel line = new JLabel("__________________________________________________________________________________________________________________________");

    String pin1;
    String pin2;
    Card cardDe;
    Color color;

    public CreateNewCardFrame() {
        this.setLayout(null);

        String[] choices = {"VISA", "MasterCard"};
        message = new JLabel("Enter 4 digits");
        message.setFont(new Font("Courier", Font.PLAIN, 10));

        header = Utils.setHeader("Enter card details");
        header.setBounds(400,100,1000,100);

        fr.add(line);
        line.setBounds(180,140,900,100);

        nameLabel = new JLabel("Name in the card");
        typeLabel = new JLabel("Type");

        final JComboBox<String> cb = new JComboBox<String>(choices);
        coChooser = new JColorChooser();

        colorLabel = new JLabel("Color");

        pinLabel = new JLabel("Pin");
        conPinLabel = new JLabel("Confirm Pin");

        colorButton = new JButton("Choose Color");

        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == colorButton) {
                    color = coChooser.showDialog(null, "", BLACK);

                }
            }
        });

        nameLabel.setBounds(380, 200, 1000, 100);
        nameText.setBounds(480, 240, 150, 20);
        typeLabel.setBounds(450, 250, 1000, 100);
        cb.setBounds(480, 290, 150, 20);
        colorLabel.setBounds(445, 310, 1000, 100);
        colorButton.setBounds(480, 350, 100, 20);
        pinLabel.setBounds(460, 350, 1000, 100);
        pinField.setBounds(480, 390, 150, 20);
        message.setBounds(480, 405, 1000, 20);
        conPinLabel.setBounds(410, 400, 1000, 100);
        conPinField.setBounds(480, 440, 150, 20);
        createCardButton.setBounds(500, 480, 100, 20);
        returnToMainPageButton.setBounds(450, 550, 200, 20);

        createCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pin1 = String.valueOf(pinField.getPassword());
                pin2 = String.valueOf(conPinField.getPassword());

                if (!checkPin(pin1, pin2)) {
                    JOptionPane.showMessageDialog(fr, "Please insert an acceptable pin!",
                            "Pin Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    Card card = new Card(0,"",0,0);
                    long cardNum = card.getCardNumber();
                    long cardCVV = card.getCvv();
                    String cardExp = card.getDateExp();
                    String cardName  = nameText.getText();
                    String typedText = ((JTextField)cb.getEditor().getEditorComponent()).getText();

                    if(cardName.equals("")){
                        JOptionPane.showMessageDialog(fr, "Please insert a Name!",
                                "Name Error", JOptionPane.ERROR_MESSAGE);
                    }


                    else {


                        fr.dispose();
                        new PreviewCardFrame(typedText, cardNum, cardExp, cardName, cardCVV, color);
                    }


                }

            }
        });

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
