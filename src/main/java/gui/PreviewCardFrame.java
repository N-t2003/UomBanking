package gui;

import model.Card;

import javax.swing.*;
import java.awt.*;

public class PreviewCardFrame extends JFrame {

    private JLabel header;
    private JFrame prFrame = new Template();
    private JPanel PrePanel = new JPanel();
    private JPanel frontCardPanel = new JPanel();
    private JPanel backCardPanel = new JPanel();
    private JTextField typeText = new JTextField();
    private JLabel carNum;

    private JLabel nameLabel = new JLabel();
    private JLabel expCard = new JLabel();
    private JLabel cardCvv = new JLabel();
    private JLabel logo = new JLabel();
    private JLabel frontLogo = new JLabel();
    private JLabel backLogo = new JLabel();
    private JPanel chipPanel = new JPanel();
    private StringBuilder cardNumberBuilder;

    //A label for valid thru card
    private JLabel expLabel;

    //Label for name of our bank
    private JLabel backLabel;
    private JLabel cvvLabel;



    public PreviewCardFrame(String type, long cardNum, String cardExp, String cardName, long cardCVV, Color cardColor) {


        StringBuilder cardNumber;
        prFrame.getContentPane();
        frontCardPanel.setLayout(null);
        backCardPanel.setLayout(null);

        cardCvv.setText(String.valueOf(cardCVV));
        expCard.setText(cardExp);
        nameLabel.setText(cardName);

        cardNumberBuilder = new StringBuilder(String.valueOf(cardNum));
        for (int i = 4; i < cardNumberBuilder.length(); i += 6) {
            cardNumberBuilder.insert(i, "  ");
        }

        carNum = new JLabel(cardNumberBuilder.toString());

        Card aCard = new Card(0, "", 0, 0);
        this.buildCard(type,cardNum,cardExp,cardName,cardCVV,cardColor);


    }

    public void buildCard(String type, long cardNum, String cardExp, String cardName, long cardCVV, Color cardColor){
        expLabel = new JLabel("VALID THRU");
        backLabel = new JLabel("UoMBanking");


        frontCardPanel.setBackground(cardColor);
        backCardPanel.setBackground(cardColor);

        header = Utils.setHeader("Your card was created successfully!");
        header.setBounds(300, 100, 1000, 100);

        PrePanel.setBounds(220, 230, 850, 230);
        PrePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        frontCardPanel.setPreferredSize(new Dimension(400, 200));
        backCardPanel.setPreferredSize(new Dimension(400, 200));
        frontCardPanel.setBounds(200, 350, 1000, 150);
        backCardPanel.setBounds(300, 300, 1000, 150);
        frontCardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        backCardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        frontCardPanel.add(nameLabel);
        Dimension sizeName = frontCardPanel.getPreferredSize();
        nameLabel.setBounds(30, 70, sizeName.width, sizeName.height);

        frontCardPanel.add(carNum);
        carNum.setBounds(50, 50, 500, 100);
        // Dimension cardNuSize = frontCardPanel.getPreferredSize();
        // carNum.setBounds(50,5,cardNuSize.width,cardNuSize.height);
        carNum.setFont(new Font("Courier", Font.PLAIN, 25));


        frontCardPanel.add(frontLogo);
        frontLogo.setBounds(10, 5, 80, 40);
        frontLogo.setIcon(Utils.setLabelIcon("src/main/java/images/UOM_LOGO_3.png", frontLogo));

        backCardPanel.add(backLogo);
        backLogo.setBounds(10, 15, 120, 60);
        backLogo.setIcon(Utils.setLabelIcon("src/main/java/images/UOM_LOGO_3.png", backLogo));


        if (type.equals("MasterCard")) {
            frontCardPanel.add(logo);
            Dimension cardTypeSize = frontCardPanel.getPreferredSize();
            logo.setBounds(290, 120, 100, 80);
            logo.setIcon(Utils.setLabelIcon("src/main/java/images/master.png", logo));
        } else {
            frontCardPanel.add(logo);
            Dimension cardTypeSize = frontCardPanel.getPreferredSize();
            logo.setBounds(300, 120, 90, 70);
            logo.setIcon(Utils.setLabelIcon("src/main/java/images/visa.jpg", logo));

        }

        frontCardPanel.add(expCard);
        Dimension expCardSize = frontCardPanel.getPreferredSize();
        expCard.setBounds(180, 80, expCardSize.width, expCardSize.height);

        frontCardPanel.add(expLabel);
        expLabel.setBounds(165, 130, 100, 50);

        frontCardPanel.add(chipPanel);
        chipPanel.setBackground(Color.LIGHT_GRAY);
        chipPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        chipPanel.setBounds(30, 50, 40, 30);


        backCardPanel.add(backLabel);
        backLabel.setBounds(140, 0, 200, 100);
        backLabel.setFont(new Font("Courier", Font.PLAIN, 25));

        backCardPanel.add(cardCvv);
        Dimension CVVSize = backCardPanel.getPreferredSize();
        cardCvv.setBounds(300, 0, CVVSize.width, CVVSize.height);

        cvvLabel = new JLabel("CVV");
        backCardPanel.add(cvvLabel);
        cvvLabel.setBounds(260, 75, 100, 50);


        PrePanel.setBackground(Color.LIGHT_GRAY);


        PrePanel.add(frontCardPanel);
        PrePanel.add(backCardPanel);


        prFrame.add(header);
        prFrame.add(PrePanel);




        prFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.LIGHT_GRAY);
        prFrame.setVisible(true);
        prFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
    }


}
