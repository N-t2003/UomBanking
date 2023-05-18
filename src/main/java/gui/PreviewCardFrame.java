
package gui;

import javax.swing.*;
import java.awt.*;

public class PreviewCardFrame extends JFrame {

    private JLabel header;
    private JPanel panel = new JPanel();
    private JFrame prFrame = new Template();
    private JPanel PrePanel = new JPanel();
    private JPanel frontCardPanel = new JPanel();
    private JPanel backCardPanel = new JPanel();
    private JTextField typeText;

    private JLabel nameLabel = new JLabel();
    private JLabel cardNumber = new JLabel();
    private JLabel cardType = new JLabel();
    private JLabel expCard = new JLabel();






    public PreviewCardFrame(String type, long cardNum, String cardExp, String cardName, long cardCVV, Color cardColor){
        prFrame.getContentPane();
        frontCardPanel.setLayout(null);


        long cardN,cardCV;


        Color cardCo;
        cardType.setText(type);
        cardCV = cardCVV;
        expCard.setText(cardExp);
        nameLabel.setText(cardName);
        cardCo=cardColor;
        cardNumber.setText(String.valueOf(cardNum));




        header = Utils.setHeader("Your card was created successfully!");
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        PrePanel.setBounds(220,230,850,250);
        PrePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        frontCardPanel.setPreferredSize(new Dimension(400,200));
        backCardPanel.setPreferredSize(new Dimension(400,200));
        frontCardPanel.setBounds(200,350,1000,150);
        backCardPanel.setBounds(300,300,1000,150);
        frontCardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        backCardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        frontCardPanel.add(nameLabel);
        Dimension sizeName = frontCardPanel.getPreferredSize();
        nameLabel.setBounds(50,70, sizeName.width,sizeName.height);

        frontCardPanel.add(cardNumber);
        Dimension cardNuSize = frontCardPanel.getPreferredSize();
        cardNumber.setBounds(50,5,cardNuSize.width,cardNuSize.height);

        frontCardPanel.add(cardType);
        Dimension cardTypeSize = frontCardPanel.getPreferredSize();
        cardType.setBounds(300,70,cardTypeSize.width,cardTypeSize.height);

        frontCardPanel.add(expCard);
        Dimension expCardSize = frontCardPanel.getPreferredSize();
        expCard.setBounds(180,40,expCardSize.width,expCardSize.height);







        PrePanel.add(frontCardPanel);
        PrePanel.add(backCardPanel);



        prFrame.add(header);
        prFrame.add(panel);
        prFrame.add(PrePanel);



        panel.setBounds(200,200,900,1);




        prFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.LIGHT_GRAY);
        prFrame.setVisible(true);
        prFrame.getContentPane().setBackground(Color.LIGHT_GRAY);

    }


}