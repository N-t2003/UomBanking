package gui;

import model.Card;

import javax.swing.*;
import java.awt.*;

public class PreviewCardFrame extends JFrame {

    private JLabel header; //επικεφαλίδα
    private JFrame prFrame = new Template();
    private JPanel PrePanel = new JPanel(); //panel που θα φιλοξενήσει τα front και back
    private JPanel frontCardPanel = new JPanel(); //μπροστά μέρος της κάρτας
    private JPanel backCardPanel = new JPanel(); //πίσω μέρος της κάρτας
    private JTextField typeText = new JTextField(); //τύπος
    private JLabel carNum; //φιλοξενία αριθμού κάρτας
    private JLabel nameLabel = new JLabel(); //φιλοξενία ονόματος κάρτας
    private JLabel expCard = new JLabel(); //φιλοξενία ημ.λήξης κάρτας
    private JLabel cardCvv = new JLabel(); //φιλοξενία cvv κάρτας
    private JLabel logo = new JLabel(); //φιλοξενία εικόνας κάρτας(MasterCard,VISA)
    private JLabel frontLogo = new JLabel(); //φιλοξενία εικόνας κάρτας(UOM)
    private JLabel backLogo = new JLabel(); //φιλοξενία εικόνας κάρτας (UOM)
    private JLabel font = new JLabel();
    private JPanel chipPanel = new JPanel(); //φιλοξενία chip κάρτας
    private StringBuilder cardNumberBuilder; // για επεξεργασία και προσθήκη κένων στον αριθμό της κάρτας

    //A label for valid thru card
    private JLabel expLabel;
    private JLabel backLabel;  //Label for name of our bank
    private JLabel cvvLabel;
    private JLabel line = new JLabel("__________________________________________________________________________________________________________________________________________");
    private JLabel deblabel = new JLabel("Debit card");



    public PreviewCardFrame(String type, long cardNum, String cardExp, String cardName, long cardCVV, Color cardColor) {

        this.setLayout(null);
        prFrame.getContentPane();
        frontCardPanel.setLayout(null);
        backCardPanel.setLayout(null);

        cardCvv.setText(String.valueOf(cardCVV));
        expCard.setText(cardExp);
        nameLabel.setText(cardName);

        //add spaces between Number of card

        cardNumberBuilder = new StringBuilder(String.valueOf(cardNum));
        for (int i = 4; i < cardNumberBuilder.length(); i += 6) {
            cardNumberBuilder.insert(i, "  ");
        }

        carNum = new JLabel(cardNumberBuilder.toString());

        Card aCard = new Card(0, "", 0, 0);
        this.buildCard(type,cardNum,cardExp,cardName,cardCVV,cardColor); //method for adding card details in panel


    }

    public void buildCard(String type, long cardNum, String cardExp, String cardName, long cardCVV, Color cardColor){
        expLabel = new JLabel("VALID THRU");
        backLabel = new JLabel("UoMBanking");

        frontCardPanel.setBackground(cardColor);
        backCardPanel.setBackground(cardColor);

        header = Utils.setHeader("Your card was created successfully!");
        header.setBounds(300, 100, 1000, 100);

        prFrame.add(line);
        line.setBounds(200,140,900,100);

        PrePanel.setBounds(220, 230, 850, 230);
        PrePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        //τοποθέτηση των 2 panel στις κατάλληλες διαστάσεις
        frontCardPanel.setPreferredSize(new Dimension(400, 200));
        backCardPanel.setPreferredSize(new Dimension(400, 200));
        frontCardPanel.setBounds(200, 350, 1000, 150);
        backCardPanel.setBounds(300, 300, 1000, 150);
        frontCardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        backCardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //Adding name in the card
        frontCardPanel.add(nameLabel);
        nameLabel.setBounds(30, 150,100, 50);

        //Adding cardType(debit,credit)
        frontCardPanel.add(deblabel);
        deblabel.setBounds(300,20,100,50);
        deblabel.setFont(new Font("Courier", Font.PLAIN, 20));


        //Adding card number in card
        frontCardPanel.add(carNum);
        carNum.setBounds(50, 50, 500, 100);
        carNum.setFont(new Font("Courier", Font.PLAIN, 25));

        //Adding UOM logo in card
        frontCardPanel.add(frontLogo);
        frontLogo.setBounds(10, 5, 80, 40);
        frontLogo.setIcon(Utils.setLabelIcon("src/main/java/images/UOM_LOGO_3.png", frontLogo));

        backCardPanel.add(backLogo);
        backLogo.setBounds(10, 30, 120, 100);
        backLogo.setIcon(Utils.setLabelIcon("src/main/java/images/UOM_LOGO_3.png", backLogo));

        //Adding the logo from type of card

        if (type.equals("MasterCard"))
        {
            frontCardPanel.add(logo);
            Dimension cardTypeSize = frontCardPanel.getPreferredSize();
            logo.setBounds(290, 120, 100, 80);
            logo.setIcon(Utils.setLabelIcon("src/main/java/images/master.png", logo));
        }
        else
        {
            frontCardPanel.add(logo);
            Dimension cardTypeSize = frontCardPanel.getPreferredSize();
            logo.setBounds(300, 120, 90, 70);
            logo.setIcon(Utils.setLabelIcon("src/main/java/images/visa.jpg", logo));
        }

        //Adding expiration date of card
        frontCardPanel.add(expCard);
        expCard.setBounds(180, 150,100,50);

        frontCardPanel.add(expLabel);
        expLabel.setBounds(165, 130, 100, 50);

        //Adding chip in card
        frontCardPanel.add(chipPanel);
        chipPanel.setBackground(Color.LIGHT_GRAY);
        chipPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        chipPanel.setBounds(30, 50, 40, 30);

        backCardPanel.add(backLabel);
        backLabel.setBounds(200, 0, 400, 50);
        backLabel.setFont(new Font("Courier", Font.PLAIN, 25));

        backCardPanel.add(cardCvv);
        cardCvv.setBounds(300, 80,100,50);

        //Adding CVV in card
        cvvLabel = new JLabel("CVV");
        backCardPanel.add(cvvLabel);
        cvvLabel.setBounds(260, 80, 100, 50);


        PrePanel.setBackground(Color.LIGHT_GRAY);
        PrePanel.add(frontCardPanel);
        PrePanel.add(backCardPanel);


        prFrame.add(header);
        prFrame.add(PrePanel);
        prFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        prFrame.setVisible(true);
        prFrame.setBackground(Color.LIGHT_GRAY);
    }
}
