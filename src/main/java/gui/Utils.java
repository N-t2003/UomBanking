package gui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Utils {

//  Used for setting a Jlabel with an icon
    public static ImageIcon setLabelIcon(String path, JLabel logo) {

        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH); //resizing the image to fit the label
        return new ImageIcon(newImg);
    }

//  Used for setting a header
    public static JLabel setHeader(String text) {
        JLabel header = new JLabel(text);
        header.setBounds(350, 100, 1000, 100);
        header.setFont(new Font("Courier", Font.PLAIN, 45));
        return header;
    }
}
